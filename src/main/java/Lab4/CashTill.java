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
    public void sellItem (Publication pPub)
    {
        runningTotal = runningTotal + pPub.getPrice();
        pPub.sellCopy();
        System.out.println("Sold " + pPub + " @ " +
                pPub.getPrice()  + "\nSubtotal = " +
                runningTotal);
    }
    public void showTotal()
    {
        System.out.println("GRAND TOTAL: " + runningTotal);
    }
}
