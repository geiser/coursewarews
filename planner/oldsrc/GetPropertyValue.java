

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.Domain;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermConstant;
import com.gamalocus.jshop2rt.TermList;

public class GetPropertyValue implements Calculate {

    @Override
    public Term call(List l) {
        if (!TermList.NIL.equals(l.getHead())) {
            String id = ((TermConstant) l.getHead()).getName();
            String name = ((TermConstant) l.getRest().getHead()).getName();
            String dest = null;
            if (l.getRest().getRest() != null) {
                dest = ((TermConstant) l.getRest().getRest().getHead()).getName();
            }
            String sql = "SELECT DISTINCT t.object FROM triples AS t WHERE t.subject='" + id + "' AND predicate='" + name + "'";
            if (dest != null) {
                sql = "SELECT DISTINCT o.object FROM triples AS o" +
                        " INNER JOIN (SELECT * FROM triples WHERE predicate='hasDestination' AND object='" + dest + "' AND subject IN (" + sql + ")) AS s ON o.subject=s.subject" +
                        " WHERE o.predicate='hasValue' AND o.subject IN (" + sql + ")";
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
                resultSet = statement.executeQuery(sql);
                Domain domain = JSHOP2Provider.getJSHOP2().getDomain();
                while (resultSet.next()) {
                    result = new TermList(domain.getTermConstant(domain.addConstant(resultSet.getString(1))), result);
                }
            } catch (SQLException e) {
                System.out.println("SQL ERROR : " + sql);
                e.printStackTrace();
            }
            return result;
        } else {
            return TermList.NIL;
        }
    }

}
