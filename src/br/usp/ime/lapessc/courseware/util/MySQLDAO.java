package br.usp.ime.lapessc.courseware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Resource;

public class MySQLDAO {

    private Connection connection;

    public MySQLDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/automatedldtest", "root", "");
        } catch (SQLException exception) {
            this.connection = null;
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    
    public boolean execute(String sql) {
    	if (this.connection != null) {
            try {
                Statement st = this.connection.createStatement();
                st.executeUpdate(sql);
                return true;
            } catch (SQLException e) {
                System.out.println("SQL ERROR : " + e.getMessage() + ", for sql " + sql); 
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean execute(Collection<String> sqls) {
        if (this.connection != null) {
            try {
                Statement st = this.connection.createStatement();
                for (String sql: sqls) {
                    st.executeUpdate(sql);
                }
                return true;
            } catch (SQLException e) {
                System.out.println("SQL ERROR : " + e.getMessage() + ", for sqls " + sqls); 
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public List<Map<String,Object>> executeQuery(String sql, String[] columns , String[] types) {
        return this.executeQuery(sql, Arrays.asList(columns), Arrays.asList(types));
    }

    public List<Map<String,Object>> executeQuery(String sql, List<String> columns , List<String> types) {
        Map<String, String> columnTypes = new HashMap<String, String>();
        for (int i = 0; i < columns.size(); i++) {
            columnTypes.put(columns.get(i), types.get(i));
        }
        return this.executeQuery(sql, columnTypes);
    }

    public List<Map<String,Object>> executeQuery(String sql, Map<String,String> columnTypes) {
        List<Map<String, Object>> toReturn = new ArrayList<Map<String,Object>>();
        try {
            Statement st = this.connection.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Map<String,Object> row = new HashMap<String, Object>();
                for (String  column : columnTypes.keySet()) {
                    Object value = null;
                    String type = columnTypes.get(column);
                    if ("Integer".equals(type) || "Int".equals(type)) {
                        value = rs.getInt(column);
                    } else if ("String".equals(type)) {
                        value = rs.getString(column);
                    }
                    row.put(column, value);
                }
                toReturn.add(row);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL ERROR : " + e.getMessage()); 
            e.printStackTrace();
        }
        return toReturn;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Resource getResource(String id) {
        MySQLDAO dao = new MySQLDAO();
        String sql = "SELECT * FROM triples WHERE subject='" + id + "'";
        List<Map<String, Object>> resourceMap = dao.executeQuery(sql, new String[]{"subject", "predicate", "object"}, new String[]{"String", "String", "String"});
        Resource toReturn = new Resource(id);
        for (Map<String, Object> triple : resourceMap) {
            String predicate = (String) triple.get("predicate");
            if ("hasHref".equals(predicate)) {
                toReturn.setHref((String) triple.get("object"));
            } else if ("hasType".equals(predicate)) {
                toReturn.setType((String) triple.get("object"));
            } else if ("hasTitle".equals(predicate)) {
                toReturn.setTitle((String) triple.get("object"));
            }
        }
        dao.close();
        return toReturn;
    }

    public static Metadata getMetadataFromMySQL(String id) {
        MySQLDAO dao = new MySQLDAO();
        String sql = "SELECT * FROM triples AS t WHERE t.subject='" + id + "'";
        List<Map<String, Object>> metadatamap = dao.executeQuery(sql, new String[]{"subject", "predicate", "object"}, new String[]{"String", "String", "String"});
        Metadata metadata = new Metadata(id);
        metadata = MetadataConverter.convert(metadatamap, metadata);
        dao.close();
        return metadata;
    }

    public static Metadata getMetadataFromResource(String id) {
        MySQLDAO dao = new MySQLDAO();
        String sql = "SELECT subject FROM triples AS t WHERE t.predicate='hasResource' AND t.object='" + id + "'";
        String metadataId = (String) dao.executeQuery(sql, new String[]{"subject"}, new String[]{"String"}).get(0).get("subject");
        dao.close();
        return getMetadataFromMySQL(metadataId);
    }



}
