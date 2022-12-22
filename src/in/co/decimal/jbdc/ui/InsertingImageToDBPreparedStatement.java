package in.co.decimal.jbdc.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingImageToDBPreparedStatement {
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

            // create query:
            // pic: is type of blob which data less than 65kb:
            String q = "insert into images(pic) values(?)";

            // get the PreparedStatement object:
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value to query of images:
            FileInputStream fis = new FileInputStream("/home/decimal/Desktop/download.jpeg");
            pstmt.setBinaryStream(1, fis, fis.available());


            // Now fire executeUpadte() command:
            pstmt.executeUpdate();

            // check whether data is inserted or not:
            System.out.println("images is inserted..");


            // close connection:
            con.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
