/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author 15022392
 */
public class CashTill {
    private double runningTotal;
    
    CashTill()
    {
        runningTotal = 0;
    }
    public void sellItem (SaleableItem sItem)
    {
        runningTotal = runningTotal + sItem.getPrice();
        sItem.sellCopy();
        System.out.println("Sold " + sItem + " @ " +
                sItem.getPrice()  + "\nSubtotal = " +
                runningTotal);
    }
    public void showTotal()
    {
        System.out.println("GRAND TOTAL: " + runningTotal);
    }
}
