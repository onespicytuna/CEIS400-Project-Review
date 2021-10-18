/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daesm
 */



public class Employee {

    //attributes
    private String empName;
    private String empType;
    private int empID;
    private int toolLoss;

    //constructors
    public Employee() 
    {
        empName = "N/A";
        empType = "N/A";
        empID = 0;
        toolLoss = 0;

    }

    public Employee(String empName, String empType, int empID, int toolLoss) 
    {
        this.empName = empName;
        this.empType = empType;
        this.empID = empID;
        this.toolLoss = toolLoss;
    }

    //behaviors
    @Override
    public String toString() {
        return empName;  //only show the employee's name
    }
    
    public String getDetails() {
        String output = empName + "\n";
        output += empType + "\n";
        output += empID + "\n";
        output += "Total Tools Lost: " + toolLoss;
           return output;

    }
    //getters & setters
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getToolLoss() {
        return toolLoss;
    }

    public void setToolLoss(int toolLoss) {
        this.toolLoss = toolLoss;
    }

}
