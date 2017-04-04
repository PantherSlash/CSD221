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
    
    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    public Publication(String title, float price, int copies){
        this.title = title;
        this.price = price;
        this.copies = copies;
    }
    
   
    public void sellCopy(){
       
    }

    @Override
    public String toString() {
        return "Title: " + title + 
                "\nPrice: " + price + 
                "\nCopies: " + copies + "\n";
    }
    
}
