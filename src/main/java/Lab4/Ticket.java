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
public class Ticket implements SaleableItem{
    private String description = "Carnival Ticket";
    private double price = 15.00;
    private String person = "You!";
    private int sold;

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPerson(String person) {
        this.person = person;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return "*********************" +
                "\n****TICKET VOUCHER***" +
                "\nDescription: " + description +
                "\nPrice: " + price +
                "\nPerson: " + person +
                "\n*********************"
                + "\n\nTickets Sold: " + getSold();
    }

    @Override
    public void sellCopy() {
        setSold(getSold() + 1);
    }
}
