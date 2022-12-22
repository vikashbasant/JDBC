package in.co.decimal.jbdc.ui;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {
        // create query:
        String q = "select * from table1";
        try (
            // create connection:
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet resultSet = stmt.executeQuery();){
            int count = 0;
            while(resultSet.next()){
                try{
                    // here 1,2,3 denote column no:
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String city = resultSet.getString(3);

                    System.out.println(id+" "+name+" "+city);
                }catch(Exception e){

                    count++;
                    System.out.println ("Data is incopitable type = " + count);
                    e.printStackTrace ();
                }
            }


            // Check query is give the data or not:
            System.out.println("Query gives the all data:");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
