package cc.rinoux.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rinoux on 2018/10/30.
 */
public class DBTools {


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            Statement statement = connection.createStatement();

            StringBuilder sc = new StringBuilder();
            sc.append("create table 110wr20col (");

            for (int i = 0; i < 20; i++) {
                if (i < 19) {
                    sc.append("col" + i).append(" varchar(20)").append(",");
                } else {
                    sc.append("col" + i).append(" varchar(20)").append(")");
                }
            }

            statement.execute(sc.toString());


            for (int i = 0; i < 1100000; i++) {

                StringBuilder sb = new StringBuilder();
                sb.append("insert into 110wr20col values(");
                for (int j = 0; j < 20; j++) {
                    if (j < 19) {
                        sb.append("\"").append("r").append(i).append("c").append(j).append("\"").append(",");
                    } else {
                        sb.append("\"").append("r").append(i).append("c").append(j).append("\"").append(")");
                    }
                }

                statement.execute(sb.toString());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
