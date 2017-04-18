/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 15022392
 */
public class App {
    boolean run = true;
    Scanner input = new Scanner(System.in);
    List<Book> b = new ArrayList<Book>();
    List<Magazine> m = new ArrayList<Magazine>();
    public void run(){
        while(run == true){
            System.out.println("------Main------");
            System.out.println("1. Books");
            System.out.println("2. Tickets");
            System.out.println("3. Magazines");
            System.out.println("99. Exit");
            int choice = input.nextInt();
            switch(choice){
                case 1: bookMenu();
                break;
                case 2: ticketMenu();
                break;
                case 3: magazineMenu();
                break;
                case 99: run = false;
                    
            }
        }
    }
    
    public void bookMenu(){
        boolean go = true;
        
        while (go == true){
        System.out.println("------Books------");
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Edit Books");
        System.out.println("4. Delete Books");
        System.out.println("5. Sell Books");
        System.out.println("6. Quit");
        }
    }
    
    public void ticketMenu(){
        boolean go = true;
        Ticket t = new Ticket();
        while (go == true){
        System.out.println("------Tickets------");
        System.out.println("1. Sell Ticket");
        System.out.println("2. Exit");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                t.sellCopy();
                System.out.println(t.toString());
            case 2: go = false;
        }
        }
    }
    
    public void magazineMenu(){
        boolean go = true;
        
        while (go == true){
        System.out.println("------Books------");
        System.out.println("1. View Magazines");
        System.out.println("2. Add Magazines");
        System.out.println("3. Edit Magazines");
        System.out.println("4. Delete Magazines");
        System.out.println("5. Sell Magazines");
        System.out.println("6. Quit");
    }
}
    private void addBook() {
        boolean add = true;
        
        while (add == true) {
            
                    System.out.println("Enter the author:");
                    input.nextLine();
                    String author = input.nextLine();
                    System.out.println("Quantity to order:");
                    int copies = input.nextInt();
      
                    System.out.println("Title:");
                    input.nextLine();
                    String title = input.nextLine();
                
                    System.out.println("Price:");
                    float price = input.nextFloat();
                    b.add(new Book(author, copies, title, price));
                    break;    
           
        }
    }

    private void editBook() {
        if (! b.isEmpty()){
boolean add = true;
int size = b.size();
        while (add == true) {
                boolean bookEdit = true;
                System.out.println("Select a book:");
                for(int i = 0; i < size;i++){
                    System.out.println(i + 1 + ". " + books.get(i).getTitle());
                }
                System.out.println(size+1 + ". Exit ");
                int bookNum = input.nextInt();
                if (bookNum == size + 1){
                    add = false;
                    break;
                }
                while(bookEdit == true){
                System.out.println("Select an editing option");
                System.out.println("1. Edit Author");
                System.out.println("2. Edit Copies");
                System.out.println("3. Edit Title");
                System.out.println("4. Edit Price");
                System.out.println("5. Exit Book Editor");
                int select = input.nextInt();
                switch(select) {
                    case 1:
                        System.out.print("Current author's name: ");
                        System.out.println(books.get(bookNum-1).getAuthor());
                        System.out.println("\nEnter a new author's name:");
                        input.nextLine();
                        String author = input.nextLine();
                        books.get(bookNum-1).setAuthor(author);
                        break;
                    case 2:
                        System.out.print("Current number of copies on order: ");
                        System.out.println(books.get(bookNum-1).getCopies());
                        System.out.println("\nEnter a new number of copies:");
                        int qty = input.nextInt();
                        books.get(bookNum-1).setCopies(qty);
                        break;
                    case 3:
                        System.out.print("Current title: ");
                        System.out.println(books.get(bookNum-1).getTitle());
                        System.out.println("\nEnter a new title:");
                        input.nextLine();
                        String title = input.nextLine();
                        books.get(bookNum-1).setTitle(title);
                        break;
                    case 4:
                        System.out.print("Current price: ");
                        System.out.println(books.get(bookNum-1).getPrice());
                        System.out.println("\nEnter a new price:");
                        float price = input.nextFloat();
                        books.get(bookNum-1).setPrice(price);
                        break;
                    case 5: 
                        bookEdit = false;
                        
                }
                }
        } 
        } else
            System.out.println("There are no books available");
    }

    private void deleteBook() {
        if (! books.isEmpty()){
            System.out.println("Select a book to remove from inventory:");
            for(int i = 0; i < books.size();i++){
                    System.out.println(i + 1 + ". " + books.get(i).getTitle());
                }
                System.out.println(books.size()+1 + ". Exit ");
            delete = input.nextInt();
            if (delete == books.size()+1){
                
            } else
            books.remove(delete-1);
            compress(0);
        } else
            System.out.println("There are no books available");
    }

    private void viewBook() {
        if (! books.isEmpty()){
            for (int i = 0; i < books.size(); i++){
                System.out.println(books.get(i));
            }
        } else
            System.out.println("There are no books available");
    }
}
