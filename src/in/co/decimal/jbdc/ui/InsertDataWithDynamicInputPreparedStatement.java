package in.co.decimal.jbdc.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertDataWithDynamicInputPreparedStatement {

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

            // Now we can create an object of BufferReader object:
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name : ");
            String name = br.readLine();

            System.out.println("Enter city : ");
            String city = br.readLine();

            // set the value to query:
            pstmt.setString(1, name);
            pstmt.setString(2, city);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
