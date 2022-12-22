package in.co.decimal.jbdc.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionJDBC {
    public static void main(String[] args) {
        try {
            // load driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create connection:
            String url, user, password;
            url = "jdbc:mysql://localhost:3306/sample";
            user = "root";
            password = "Vikky@333";
            Connection con = DriverManager.getConnection(url, user, password);

            // check whether connection is made or not:
            if(con.isClosed()){
                System.out.println("Connection is still closed");
            }else{
                System.out.println("Connection is Made, Relax Man Chill...");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
