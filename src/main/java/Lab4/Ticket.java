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
public class Ticket {
    private String description = "Carnival Ticket";
    private double price = 15.00;
    private String person = "You!";

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPerson(String person) {
        this.person = person;
    }
    
    public double getPrice() {
        return price;
    }

    public String sellCopy(){
        return "*********************" +
                "\n****TICKET VOUCHER***" +
                toString() +
                "\n*********************";
    }
    @Override
    public String toString(){
        return "\nDescription: " + description +
                "\nPrice: " + price +
                "\nPerson: " + person;
    }
}
