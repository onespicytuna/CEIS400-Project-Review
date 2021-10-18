
   
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daesm
 */
public class Tool {

    //attributes
    private int itemID;
    private String toolNm;
    private double amt;
    

    //constructors
    public Tool() {
        itemID = 0;
        toolNm = "N/A";
        amt = 0.0;
       
        
    }

    public Tool(int itemId, String toolNm, double Amt) {
        this.itemID = itemId;
        this.toolNm = toolNm;
        this.amt = Amt;
        
       
    }

    //behaviors
    @Override
    public String toString() {
        return toolNm;  //only show the tools's name
    }

    public String getToolDetails() {
        DecimalFormat fmt = new DecimalFormat("$#,##0.00");
        String output = toolNm + "\n";
        output += "Total Amount: " + fmt.format(amt); //currency
    
        return output;

    }
    //getters and setters
    public int getItmID() {
        return itemID;
    }

    public void setItmID(int itmID) {
        this.itemID = itmID;
    }
    
    public String getToolNm() {
        return toolNm;
    }

    public void setToolNm(String toolNm) {
        this.toolNm = toolNm;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    
}


