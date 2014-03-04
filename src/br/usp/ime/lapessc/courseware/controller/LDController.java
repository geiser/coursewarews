package br.usp.ime.lapessc.courseware.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.jdom.JDOMException;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.lapessc.courseware.mediator.GetPropertyValue;
import br.usp.ime.lapessc.courseware.model.LDElement;
import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Property;
import br.usp.ime.lapessc.courseware.model.PublicTask;
import br.usp.ime.lapessc.courseware.model.UserInfo;
import br.usp.ime.lapessc.courseware.planner.Solver;
import br.usp.ime.lapessc.courseware.planner.jshop2ip.JShop2ipSolver;
import br.usp.ime.lapessc.courseware.util.LDElementConverter;
import br.usp.ime.lapessc.courseware.util.MySQLDAO;

@Resource
@RequestScoped
public class LDController {

    private final Result result;
    private final UserInfo userInfo;

    public LDController(Result result, UserInfo userInfo) {
        this.result = result;
        this.userInfo = userInfo;
    }
    
    @Get
    @Path(value = "/uols/{id}/lds")
    public void list(String callback) {
    	String sql = "SELECT DISTINCT t.subject FROM triples AS t";
    	sql += " INNER JOIN (SELECT * FROM triples WHERE predicate='type' AND object='Fundamental') AS t0 ON t.subject=t0.subject";
    	sql += " INNER JOIN (SELECT * FROM triples WHERE predicate='type' AND object='UoL') AS t1 ON t.subject=t1.subject";
    	MySQLDAO mysql = new MySQLDAO();
	    List<Map<String, Object>> result = mysql.executeQuery(sql, new String[]{"subject"}, new String[]{"String"});
	    
	    Collection<LDElement> courses = new HashSet<LDElement>();
	    for (Map<String, Object> row : result) {
	        String metadataId = (String) row.get("subject");
	        Metadata metadata = MySQLDAO.getMetadataFromMySQL(metadataId);
	        LDElement element = this.getLDElementFromMySQL(metadata, mysql);
	        courses.add(element);
	    }
	    mysql.close();
        this.result.include("callback", callback);
		this.result.include("courses", courses);
    }
    
    @Post
    @Path(value = "/uols/{id}/lds")
    public void create(PublicTask initialTask, String initialState) throws ServiceException, JDOMException, IOException {
        Solver solver = new JShop2ipSolver();
        solver.setMediatorURL(this.userInfo.getMediatorURL());
        LDElement element = solver.solve(initialTask, initialState);

        //-- get map of user -> roles or groups
        Map<String, Collection<String>> userRolesOrGroups = new HashMap<String, Collection<String>>();
        if (element.getMetadata().getProperties("hasUserInRole") != null) {
            for (Property userInRoleProperty : element.getMetadata().getProperties("hasUserInRole")) {
                String[] userRole = userInRoleProperty.getValue().substring(1, userInRoleProperty.getValue().length()-1).split("[ ]+");
                Collection<String> roles = userRolesOrGroups.get(userRole[0]);
                if (roles == null) { roles = new ArrayList<String>(); }
                roles.add(userRole[1]);
                userRolesOrGroups.put(userRole[0], roles);
            }
        }
        if (element.getMetadata().getProperties("hasUserInGroup") != null) {
            for (Property userInGroupProperty : element.getMetadata().getProperties("hasUserInGroup")) {
                String[] userGroup = userInGroupProperty.getValue().substring(1, userInGroupProperty.getValue().length()-1).split("[ ]+");
                Collection<String> groups = userRolesOrGroups.get(userGroup[0]);
                if (groups == null) { groups = new ArrayList<String>(); }
                groups.add(userGroup[1]);
                userRolesOrGroups.put(userGroup[0], groups);
            }
        }
        
        List<String> sqls = new LDElementConverter(element).toSQL();
        MySQLDAO mysql = new MySQLDAO();
        if (mysql.execute(sqls)) {
            mysql.close();
        }
    }
    
    @Get
    @Path(value = "/uols/{id}/lds/{e}")
    public void read(String id, String e) {
    	MySQLDAO mysql = new MySQLDAO();
    	LDElement course = this.getLDElementFromMySQL(e, mysql);
    	mysql.close();
    	course.getMetadata().getProperties("hasRunForUoL");
    	
    	Map<String, String> participants = new HashMap<String, String>();
    	for (Property participantProperty : course.getMetadata().getProperties("hasParticipant")) {
    	    String username = GetPropertyValue.getValues(participantProperty.getValue(), "hasUserName", null).iterator().next();
            participants.put(participantProperty.getValue(), username);
    	}
    	
    	this.result.include("participants", participants);
		this.result.include("course", course);
		this.result.include("runId", course.getMetadata().getProperties("hasRun").iterator().next().getValue());
    	this.result.include("urlCCBase", "http://localhost:8780");
    }
    
    private LDElement getLDElementFromMySQL(String id, MySQLDAO mysql) {
        String sql = "SELECT * FROM ldelements WHERE id = '" + id + "'";
        String metadataId = (String) mysql.executeQuery(sql, new String[]{"metadata"}, new String[]{"String"}).get(0).get("metadata");
        Metadata metadata = MySQLDAO.getMetadataFromMySQL(metadataId);
        return this.getLDElementFromMySQL(metadata, mysql);
    }
    
    private LDElement getLDElementFromMySQL(Metadata metadata, MySQLDAO mysql) {
        //-- set ldelement
        String sql = "SELECT * FROM ldelements WHERE metadata = '" + metadata.getId() + "'";
        Map<String, Object> ldmap = mysql.executeQuery(sql, new String[]{"id", "type", "tag", "metadata"},
                                                            new String[]{"String", "String", "String", "String"}).get(0);
        LDElement element = new LDElement();
        element.setId((String) ldmap.get("id"));
        element.setType(LDElement.Type.getByValue((String) ldmap.get("type")));
        element.setTag((String) ldmap.get("tag"));
        element.setMetadata(metadata);
        return element;
    }

    @Delete
    @Path(value = "/uols/{id}/lds/{e}")
    public void delete(String id, String e) {
    	MySQLDAO mysql = new MySQLDAO();
    	String sql = "DELETE * FROM ldelements WHERE id ='" + e + "'";
    	this.result.include("delete", mysql.execute(sql));
    	mysql.close();
    }
    
}
