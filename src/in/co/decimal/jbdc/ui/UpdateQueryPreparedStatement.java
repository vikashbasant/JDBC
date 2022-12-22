package in.co.decimal.jbdc.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQueryPreparedStatement {

    public static void main(String[] args) {


        try {
            // create connection:
            Connection con = ConnectionProvider.getConnection();

            // create query:
            String q = "update table1 set tName = ?, tCity = ? where tId = ?";

            // create bufferReader object:
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new name : ");
            String name = br.readLine();

            System.out.println("Enter new city : ");
            String city = br.readLine();

            System.out.println("Enter the student id : ");
            int id = Integer.parseInt(br.readLine());

            // get the PreparedStatement object:
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value to query:
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);

            // fire query:
            pstmt.executeUpdate();

            // Check query is update or not:
            System.out.println("Query is updated:");

            // Connection closed:
            con.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
