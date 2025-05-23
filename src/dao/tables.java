package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tables {
    public static void main (String[] args) {
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            if(!tableExists(st, "Employee")){
                st.executeUpdate("CREATE TABLE Employee (employeeID INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(255) not null, gender VARCHAR(50) not null, email VARCHAR(255) not null, contact VARCHAR(20) not null, address VARCHAR(500), state VARCHAR(100), country VARCHAR(100), uniqueregid VARCHAR(100) not null, imagename VARCHAR(100));");
            }
            if(!tableExists(st, "Attendance")){
                st.executeUpdate("CREATE TABLE Attendance (employeeID INT NOT NULL, date DATE NOT NULL, checkin DATETIME, checkout DATETIME, workduration VARCHAR(100));");
            }
            JOptionPane.showMessageDialog(null, "Tables Checked/Created Successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(st!=null){
                    st.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static boolean tableExists(Statement st, String tableName) throws Exception {
        ResultSet resultSet = st.executeQuery("SHOW TABLES LIKE '" + tableName + "'");
        return resultSet.next();
    }
}
