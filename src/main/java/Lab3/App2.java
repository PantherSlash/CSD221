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
    
    public void run(){
        while (loop == true){
        System.out.println("------Books------");
        if (! books.isEmpty()) {
            for (int i = 0; i < books.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(books.get(i).getTitle());
            }
          
        }
        System.out.println("-----------------");
          System.out.println("3. Add a book");
          System.out.println("4. Edit a book");
          System.out.println("5. Delete a book");
          System.out.println("6. Quit");
        int choice = input.nextInt();
            switch (choice) {
                case 3:
                    addBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
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
            
                    System.out.println("Enter the author: ('q' to Quit)");
                    String author = input.nextLine();
                    input.nextLine();
                    if (author == "q"){
                        
                        add = false;
                        break;
                    }
                    System.out.println("Quantity to order:");
                    int copies = input.nextInt();
      
                    System.out.println("Title:");
                    String title = input.nextLine();
                    input.nextLine();
                    System.out.println("Price:");
                    float price = input.nextFloat();
                    books.add(new Book(author, copies, title, price));
                    break;    
           
        }
    }

    private void editBook() {

    }

    private void deleteBook() {

    }
}
