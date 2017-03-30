/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author 15022392
 */
public class Publication {
    String title;
    float price;
    int copies;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
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
    
    public float sellCopies(){
        float total;
        total = this.copies * this.price;
        return total;
    }

    @Override
    public String toString() {
        return "Title: " + title + 
                "\nPrice: " + price + 
                "\nCopies: " + copies + "\n";
    }
    
}
