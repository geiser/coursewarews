package br.usp.ime.lapessc.courseware.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.apache.commons.httpclient.HttpException;
import org.jdom.JDOMException;
import org.tencompetence.ldpublisher.IPublishHandler;
import org.tencompetence.ldpublisher.PublishHandler;
import org.tencompetence.ldpublisher.model.IRole;
import org.tencompetence.ldpublisher.upload.ICancelMonitor;
import org.tencompetence.ldpublisher.upload.ICancelable;

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
import br.usp.ime.lapessc.courseware.util.LDResources;
import br.usp.ime.lapessc.courseware.util.MySQLDAO;

@Resource
@RequestScoped
public class UoLController {

	private final Result result;
	private final HttpServletRequest request;

	private IPublishHandler handler;
	private final UserInfo userInfo;

	public UoLController(Result result, UserInfo userInfo, HttpServletRequest request) {
		this.result = result;
		this.userInfo = userInfo;
		try {
			this.handler = new PublishHandler("http://localhost:8780", "", "");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.request = request;
	}

	@Get
	@Path(value = "/uols")
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
	@Path(value = "/uols")
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

		//-- make uols zips
		String uolPath = this.request.getServletContext().getRealPath(File.separator) + "files" + File.separator + "uol";
		System.out.println("path :: " + uolPath);
		Map<LDElement, File> files = null;
		try {
			files = element.toUoL(uolPath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (LDElement ld : files.keySet()) {
			File file = files.get(ld);
			try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
				this.handler.publishUol(file, new ICancelMonitor() {
					public void setOperation(ICancelable method) {
						// TODO Auto-generated method stub
					}
					public void releaseOperation() {
						// TODO Auto-generated method stub
					}
				});
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int uolId = this.handler.findUolInCC(LDResources.baseURL + "/uols/" + file.getName());
			if (uolId != -1) {
				String title = ld.getMetadata().getTitle();
				if (title == null || title.isEmpty()) {
					title = file.getName();
				}
				int runId = this.handler.createRunForUol(uolId, title);
				ld.getMetadata().addProperty(new Property().setName("hasRun").setValue(""+ runId));

				String[] roleTree = this.handler.getRolesTree(runId).split(System.getProperty("line.separator"));
				for (Property userProperty : ld.getMetadata().getProperties("hasParticipant")) {
					String userId = userProperty.getValue();
					try {
						this.handler.createUser(userId);
					} catch (Exception e) {
					}
					//-- set user to run
					this.handler.addUserToRun(userId, runId);
					ld.getMetadata().addProperty(new Property().
							setName("hasRunForUoL").
							setValue("(" + userId + " " + runId + ")"));
					//-- set role to user
					Collection<String> rolesGroups = userRolesOrGroups.get(userId);
					if (rolesGroups != null) {
						for (String roleGroup : rolesGroups) {
							for (IRole role : this.handler.getRoles(runId)) {
								for (String line : roleTree) {
									if (line.contains("\"" + role.getCopperCoreKey() + "\"") && line.contains(roleGroup)) {
										this.handler.addUserToRole(userId, role.getCopperCoreKey());
									}
								} 
							}
						}
					}
				}
			}
		}

		List<String> sqls = new LDElementConverter(element).toSQL();
		MySQLDAO mysql = new MySQLDAO();
		if (mysql.execute(sqls)) {
			mysql.close();
		}
	}

	@Get
	@Path(value = "/uols/{id}")
	public void read(String id) {
		MySQLDAO mysql = new MySQLDAO();
		LDElement course = this.getLDElementFromMySQL(id, mysql);
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
	@Path(value = "/uols/{id}")
	public void delete(String id) {
		MySQLDAO mysql = new MySQLDAO();
		String sql = "DELETE * FROM ldelements WHERE id ='" + id + "'";
		this.result.include("delete", mysql.execute(sql));
		mysql.close();
	}

	@Get
	@Path("/uol/{id}/run")
	public void showRun(String id) {
		String sql = "SELECT object FROM triples WHERE subject='" + id + "' AND predicate='hasRunForUoL'";
		MySQLDAO mysql = new MySQLDAO();
		List<Map<String, Object>> rows = mysql.executeQuery(sql, Arrays.asList(new String[]{"object"}), Arrays.asList(new String[]{"String"}));
		mysql.close();

		Map<String, List<String>> learnerRuns = new HashMap<String, List<String>>();
		for (Map<String, Object> row : rows) {
			String learnerRunVar = (String) row.get("object");
			String[] learnerRun = learnerRunVar.substring(1, learnerRunVar.length()-1).split("[ ]+");
			String username = GetPropertyValue.getValues(learnerRun[0], "hasUserName", null).iterator().next();
			List<String> value = Arrays.asList(new String[]{username, learnerRun[1]});
			learnerRuns.put(learnerRun[0], value);
		}

		result.include("urlCCBase", "http://localhost:8780");
		result.include("learnerRuns", learnerRuns);
	}
	
	@Path("/uols/{id}.zip")
	public File getUoL(String id) {
		String uolPath = this.request.getServletContext().getRealPath(File.separator) + "files" + File.separator + "uol";
		return new File(uolPath + File.separator + id + ".zip");
	}

	@Path("/uols/{id}/imsmanifest.xml")
	public File getManifest(String id) {
		String uolPath = this.request.getServletContext().getRealPath(File.separator) + "files" + File.separator + "uol";
		return new File(uolPath + File.separator + id + File.separator + "imsmanifest.xml");
	}

}