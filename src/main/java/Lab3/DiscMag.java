/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;
import java.util.Date;
/**
 *
 * @author 15022392
 */
public class DiscMag extends Magazine{
    
    public DiscMag (String title, float price, int copies, int orderQty, Date currIssue) {
        super(title, price, copies, orderQty, currIssue);
        this.currIssue = currIssue;
    }
    
    @Override
    public void recvNewIssue(Date newIssue) {
        super.currIssue = newIssue;
    }
}
