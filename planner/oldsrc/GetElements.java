
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;

public class GetElements implements Calculate {

    public static String termToString(Term term) {
        String result = "";
        if (term instanceof TermConstant) {
            result = ((TermConstant) term).getName();
        } else if (term instanceof TermNumber) {
            result = new Double(((TermNumber) term).getNumber()).intValue() + "";
        } else if (term instanceof TermList) {
            List list = ((TermList) term).getList();
            String s = "";
            while (list != null) {
                s += " " + termToString(list.getHead());
                list = list.getRest();
            }
            if (s!=null && !s.isEmpty()) {
                result += "(" + s.substring(1) + ")";
            }
        }
        return result;
    }

    public static String[] listToArray(List list) {
        ArrayList<String> result = new ArrayList<String>();
        while (list != null) {
            result.add(termToString(list.getHead()));
            list = list.getRest();
        }
        String[] toReturn = new String[result.size()];
        for (int i = 0; i < result.size(); i++) { toReturn[i] = result.get(i); }
        return toReturn;
    }
    
    @Override
    public Term call(List l) {
        Set<String> types = new HashSet<String>();
        Set<String[]> relations = new HashSet<String[]>();
        Set<String[]> properties = new HashSet<String[]>();
        //-- get parameters
        l = ((TermList) l.getHead()).getList();
        while (l != null) {
            List arg = ((TermList) l.getHead()).getList();
            String type = ((TermConstant) arg.getHead()).getName().toLowerCase();
            if ("class".equals(type)) {
                types.add(((TermConstant) arg.getRest().getHead()).getName());
            } else if ("property".equals(type)) { //(property ?name [?dest [?value]])
                properties.add(listToArray(arg.getRest()));
            } else if ("relation".equals(type)) {
                relations.add(listToArray(arg.getRest()));
            }
            l = l.getRest();
        }
        //-- get SQL query
        int count = 0;
        String sql = "SELECT DISTINCT t.subject FROM triples AS t";
        if (!types.isEmpty()) {
            for (String type : types) {
                sql += " INNER JOIN (SELECT * FROM triples WHERE predicate='type' AND object='" + type + "') AS t" + count + " ON t.subject=t" + count + ".subject";
                count++;
            }
        }
        for (String[] property : properties) {
            sql += " INNER JOIN";
            if (property.length == 3) {
//                sql += " (SELECT * FROM triples WHERE predicate='" + property[0] + "' AND object"
//                            + " IN (SELECT dv.subject FROM triples AS dv"
//                            + " INNER JOIN (SELECT * FROM triples WHERE predicate='hasDestination' AND object='" + property[1] + "') AS d ON dv.subject=d.subject"
//                            + " INNER JOIN (SELECT * FROM triples WHERE predicate='hasValue' AND object='" + property[2] + "') AS v ON dv.subject=v.subject"
//                            + ")) AS t" + count + " ON t.subject=t" + count + ".subject";
                sql += " (SELECT * FROM triples WHERE predicate='" + property[0] + "' AND object='" + property[1] + property[2] + "') AS t" + count + " ON t.subject=t" + count + ".subject";
            } else if (property.length == 2) {
                sql += " (SELECT * FROM triples WHERE predicate='" + property[0] + "' AND object='" + property[1] + "') AS t" + count + " ON t.subject=t" + count + ".subject";
            }
            count++;
        }
        for (String[] relation :  relations) {
            sql += " INNER JOIN (SELECT * FROM triples WHERE predicate='" + relation[0] + "' AND object='" + relation[1] + "') AS t" + count + " ON t.subject=t" + count + ".subject";
            count++;
        }
        //-- execute SQL query
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) { e1.printStackTrace(); }
        Connection connection;
        ResultSet resultSet = null;
        TermList result = TermList.NIL;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/automatedldtest", "root", "");
            Statement statement = connection.createStatement();
            //System.out.println("GetElements (query) : " + sql);
            resultSet = statement.executeQuery(sql);
            Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
            while (resultSet.next()) {
                result = new TermList(domain.getTermConstant(domain.addConstant(resultSet.getString(1))), result);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }
    
}