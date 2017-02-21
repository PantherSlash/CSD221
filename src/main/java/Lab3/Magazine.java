/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 15022392
 */
public class Magazine extends Publication{
    private int orderQTY;
    private Date currIssue;
    
    public int getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(int orderQTY) {
        this.orderQTY = orderQTY;
    }

    public Date getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }
   
    public Magazine(String title, float price, int copies, int orderQTY, Date currIssue){
        super(title, price, copies);
        this.orderQTY = orderQTY;
        this.currIssue = currIssue;
    }
    public void adjustQTY(int qty){
        orderQTY = qty;
    }
    
    public void recvNewIssue(Date newIssue){
        currIssue = newIssue;
    }
    
    String datePattern = "MMM-dd-yyyy";
    SimpleDateFormat date = new SimpleDateFormat(datePattern);
    
    @Override
    public String toString() {
        return super.toString() + 
                "\nOrder QTY: " + orderQTY + 
                "\nCurrent Issue:" + date.format(currIssue) + "\n";
    } 
}
