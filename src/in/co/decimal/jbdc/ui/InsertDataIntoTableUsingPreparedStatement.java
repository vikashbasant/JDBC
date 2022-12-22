package in.co.decimal.jbdc.ui;

import java.sql.*;

public class InsertDataIntoTableUsingPreparedStatement {

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
            String q = "insert into table1(tName, tCity) values(?, ?)";

            // get the PreparedStatement object:
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value to query:
            pstmt.setString(1,"Vikash Basant");
            pstmt.setString(2,"Bihar");

            // set the value to query:
            pstmt.setString(1,"Prince Saxena");
            pstmt.setString(2,"Delhi");

            // Now fire executeUpadte() command:
            pstmt.executeUpdate();

            // check whether data is inserted or not:
            System.out.println("Data is inserted..");


            // close connection:
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
