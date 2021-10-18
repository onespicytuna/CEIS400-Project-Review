/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author daesm
 */
public class ToolDataIO {

    //constants
    private final String DATABASE_NAME = "ceis400";
    private final String CONNECTION_STRING
            = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";

    //behaviors
    public void add (Tool tooldb) throws ClassNotFoundException, SQLException {
        //check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //connect to database 
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        //add record 
        String strSQL = "INSERT INTO tooldb (toolNm, toolamt) "
                + "VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, tooldb.getToolNm());
        pstmt.setDouble(2, tooldb.getAmt());

        // execute the prepared statement
        pstmt.execute();

        //close connection 
        conn.close();

    }

    /*public void delete(int itemID) throws SQLException {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        // delete the record
        String SQL = "DELETE FROM tooldb WHERE itemID = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, itemID);
        pstmt.execute();

        // close the database connection
        conn.close();
    }*/

    public ArrayList<Tool> getList() throws SQLException {
        // create the ArrayList so we have something to return
        ArrayList<Tool> list = new ArrayList<Tool>();

        //connect to database 
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        Statement statement = conn.createStatement();
        String SQL = "Select * FROM tooldb";
        ResultSet rs = statement.executeQuery(SQL);

        while (rs.next()) {
            // create Tool object and load the attributes
            Tool toolitem = new Tool();
            toolitem.setToolNm(rs.getString(1));
            toolitem.setAmt(rs.getDouble(2));
            
            // add the Tool object to our list
            list.add(toolitem);
        }

        // close the database connection
        conn.close();

        // return the ArrayList
        return list;
    }

}//end of the class - do not code beyond this line

