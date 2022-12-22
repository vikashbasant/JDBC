package in.co.decimal.jbdc.ui;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingLargeImageToDBPreparedStatement {

    public static void main(String[] args) {

        try {
            // Create Connection:
            Connection con = ConnectionProvider.getConnection();

            // create query:
            // pic: is type of longblob which data :
            String q = "insert into images(pic) values(?)";

            // get the PreparedStatement object:
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value to query of images:

            // this is part swing:
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis, fis.available());


            // Now query fire executeUpadte() command:
            pstmt.executeUpdate();

            // check whether data is inserted or not:
//            System.out.println("images is inserted..");

            JOptionPane.showMessageDialog(null, "Images is inserted");


            // close connection:
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
