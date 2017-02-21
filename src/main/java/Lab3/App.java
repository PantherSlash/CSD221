/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 15022392
 */
public class App {

    Scanner input = new Scanner(System.in);
    String datePattern = "MMM-dd-yyyy";
    SimpleDateFormat date = new SimpleDateFormat(datePattern);
    boolean loop = true;
    List<Book> books = new ArrayList<Book>();
    List<Publication> magazine = new ArrayList<Publication>();
    public void run() {
        
        while (loop == true) {
            System.out.println("---Books CRUD Interface---");
            System.out.println("1. View");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("99. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewBook();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 99:
                    loop = false;
                    break;
                default:
                    System.out.println("Error. Invalid input");
            }
        }
    }

    private void viewBook() {
        System.out.println("List of Books: ");
if (! books.isEmpty()) {
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books);
            }
    }
System.out.println("List of Magazines: ");
if (! magazine.isEmpty()) {
            for (int i = 0; i < magazine.size(); i++) {
                System.out.println(magazine);
            }
    }
    }
    
    private void addBook() {
        boolean add = true;
        
        while (add == true) {
            System.out.println("Select the type of publication to add");
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("99. Exit Adding Menu");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the title of a book: ");
                    String title = input.next();
                    System.out.println("Enter the price of the book: ");
                    float price = input.nextInt();
                    System.out.println("Enter the number of copies for the book: ");
                    int copies = input.nextInt();
                    System.out.println("Enter the author of the book: ");
                    String author = input.next();
                    //books.add(new Book(title, price, copies, author));
                    break;
                
                }
                case 2: {
                    System.out.println("Enter the title of a magazine: ");
                    String title = input.next();
                    System.out.println("Enter the price of the magazine: ");
                    float price = input.nextInt();
                    System.out.println("Enter the number of copies for the magazine: ");
                    int copies = input.nextInt();
                    System.out.println("Enter the amount to order: ");
                    int orderQTY = input.nextInt();
                    System.out.println("Enter the current magazine issue: ");
                    Date issue = getDate(date);
                    magazine.add(new Magazine(title, price, copies, orderQTY, issue));
                    break;
                   
                }
                case 99:
                    add = false;
                    break;
                default:
                    System.out.println("Error, invalid input");
            }
        }
    }

    private void editBook() {

    }

    private void deleteBook() {

    }
    
    private static Date getDate(SimpleDateFormat format) {
        Date date = null;
        Scanner input = new Scanner(System.in);
        while (date == null) {
            String line = input.nextLine();
            try {
                date = format.parse(line);
            } catch (ParseException e) {
                System.out.println("Sorry, that's not valid. Please try again.");
            }
        }
        return date;
    }
}

