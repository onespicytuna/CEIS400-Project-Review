
/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;*/
import java.sql.*;
import java.util.ArrayList;

/**
 * **************************************************
 * Program Name: ToolInventory.java Programmer's Name: Justin Tramber Program
 * Description: Read and Write to Files
 * *********************************************************
 */
/**
 *
 * @author daesm
 */
public class DataIO {

    //constants
    private final String DATABASE_NAME = "ceis400";
    private final String CONNECTION_STRING
            = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";

    //behaviors
    public void add(Employee emp) throws ClassNotFoundException, SQLException {
        //check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //connect to database 
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        //add record 
        String strSQL = "INSERT INTO employeedb (EmployeeName, EmployeeType, "
                + "EmployeeID, ToolLoss) "
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, emp.getEmpName());
        pstmt.setString(2, emp.getEmpType());
        pstmt.setInt(3, emp.getEmpID());
        pstmt.setInt(4, emp.getToolLoss());
        

        // execute the prepared statement
        pstmt.execute();

        //close connection 
        conn.close();

    }

    /*public void delete(int customerID) throws SQLException {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        // delete the record
        String SQL = "DELETE FROM employeeDB WHERE CustomerID = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, customerID);
        pstmt.execute();

        // close the database connection
        conn.close();
    }
*/

public ArrayList<Employee> getList() throws SQLException {
        // create the ArrayList so we have something to return
        ArrayList<Employee> list = new ArrayList<Employee>();

        //connect to database 
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        Statement statement = conn.createStatement();
        String SQL = "Select * FROM employeedb";
        ResultSet rs = statement.executeQuery(SQL);

        while (rs.next()) {
            // create Employee object and load the attributes
            Employee empdb = new Employee();
            empdb.setEmpName(rs.getString(1));
            empdb.setEmpType(rs.getString(2));
            empdb.setEmpID(rs.getInt(3));            
            empdb.setToolLoss(rs.getInt(4));


            // add the Employee object to our list
            list.add(empdb);
        }

        // close the database connection
        conn.close();

        // return the ArrayList
        return list;
    }

}//end of the class - do not code beyond this line

