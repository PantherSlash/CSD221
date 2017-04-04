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
public class Book extends Publication{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Book(String author, int copies , String title, float price){
        super(title, price, copies);
        this.author = author;
    }
    public void orderCopies(int moreCopies){
        
    }

    @Override
    public String toString() {
        return super.toString() + 
                "\nAuthor:" + author + "\n";
    }

    @Override
    public void sellCopy() {
        setCopies(getCopies()-1);
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}
