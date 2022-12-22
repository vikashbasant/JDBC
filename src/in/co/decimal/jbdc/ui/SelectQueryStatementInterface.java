package in.co.decimal.jbdc.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQueryStatementInterface {
    public static void main(String[] args) {
        try {
            // create connection:
            Connection con = ConnectionProvider.getConnection();

            // create query:
            String q = "select * from table1";

            // create statement:
            Statement stmt = con.createStatement();

            // query fire:
            ResultSet set = stmt.executeQuery(q);

            // Fetch data from the ResultSet:
            while(set.next()){
                // here 1,2,3 denote column no:
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);

                System.out.println(id+" "+name+" "+city);
            }


            // Check query is give the data or not:
            System.out.println("Query gives the all data:");

            // Connection closed:
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
