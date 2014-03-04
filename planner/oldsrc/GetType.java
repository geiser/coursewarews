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


public class GetType implements Calculate {

    @Override
    public Term call(List l) {
        String id = ((TermConstant) l.getHead()).getName();
        String sql = "SELECT DISTINCT t.object FROM triples AS t WHERE t.subject='" + id + "' AND predicate='type'";
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
        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }

}
