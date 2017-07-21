package cc.rinoux.dbdatagenerator;

import cc.rinoux.designpattern.adapterpattern.Target;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.*;

/**
 * Created by rinoux on 2017/6/16.
 */
public class DBDataGenerator {
    private static Connection createConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/rinoux";
        String user = "root";
        String psw = "rinoux.44";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, psw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    private static Object execute(String sql) throws ClassNotFoundException, SQLException {
        Connection connection = createConnection();
        if (connection != null) {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        }
        connection.commit();
        connection.close();
        return null;
    }

    public static void insertIntoTable(String tableName, String... content) {
        String checkTable = "SELECT * FROM " + tableName;
        try {
            execute(checkTable);
        } catch (ClassNotFoundException | SQLException e) {
            if (e instanceof MySQLSyntaxErrorException) {
                createTable(tableName, content);
            }
        }

        String sql = "INSERT INTO";
    }

    private static void createTable(String name, String... content) {
        StringBuffer sb = new StringBuffer().append(" (");
        int c = 0, d = 0;
        for (int i = 0, len = content.length; i < len; i++) {
            String s = content[i];
            try {
                Integer.parseInt(s);
                sb.append("'").append("num").append(c++).append("'").append(" INT(10)");
                if (i < len - 1) {
                    sb.append(", ");
                }
            } catch (NumberFormatException e) {
                sb.append("'").append("val").append(d++).append("'").append(" VARCHAR(100)");
                if (i < len - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append(") ");

        String sql = "CREATE TABLE '" + name  + "'" + sb.toString() + ";";
        try {
            execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        insertIntoTable("hello", "");
    }

}
