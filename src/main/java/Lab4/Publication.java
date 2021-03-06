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
public abstract class Publication implements SaleableItem{
    String title;
    double price;
    int copies;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    public Publication(String title, double price, int copies){
        this.title = title;
        this.price = price;
        this.copies = copies;
    }
    
   
   
    @Override
    public String toString() {
        return "Title: " + title + 
                "\nPrice: " + price + 
                "\nCopies: " + copies + "\n";
    }
}
