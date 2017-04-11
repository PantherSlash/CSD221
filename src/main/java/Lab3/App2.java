/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 15022392
 */
public class App2 {
    Scanner input = new Scanner(System.in);
    String datePattern = "MMM-dd-yyyy";
    SimpleDateFormat date = new SimpleDateFormat(datePattern);
    boolean loop = true;
    List<Book> books = new ArrayList<Book>();
    int delete = 0;
    public void run(){
        while (loop == true){
        System.out.println("------Books------");
          System.out.println("1. Add a book");
          System.out.println("2. Edit a book");
          System.out.println("3. Delete a book");
          System.out.println("4. View a book");
          System.out.println("99. Quit");
        int choice = input.nextInt();
            switch (choice) { 
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    viewBook();
                    break;
                case 99:
                    loop = false;
                    break;
                default:
                    System.out.println("Error. Invalid input");
            }
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
                    books.add(new Book(author, copies, title, price));
                    break;    
           
        }
    }

    private void editBook() {
        if (! books.isEmpty()){
boolean add = true;
int size = books.size();
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
    
    private void compress(int i) {
        if (delete >= books.size() - 1) {
            return;
        }
        while (i != books.size() - 1 && delete < books.size() - 1) {
            if (books.get(i) == null && books.get(i+1) != null) {
                books.set(i,books.get(i+1));
                books.remove(i + 1);
            }
            compress(i + 1);
        }
        compress(0);
    }
}
