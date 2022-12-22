package in.co.decimal.jbdc.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
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

            // create a query:
            String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(200))";

            //create a statement:
            Statement stmt = con.createStatement();

            stmt.executeUpdate(q);

            System.out.println("table created in datatbase..");

            // close connection:
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
