/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 15022392
 */
public class App {

    String datePattern = "MMM-dd-yyyy";
    SimpleDateFormat date = new SimpleDateFormat(datePattern);
    CashTill cT = new CashTill();
    int delete = 0;
    boolean run = true;
    Scanner input = new Scanner(System.in);
    List<Book> b = new ArrayList<Book>();
    List<Magazine> m = new ArrayList<Magazine>();

    public void run() {
        while (run == true) {
            System.out.println("------Main------");
            System.out.println("1. Books");
            System.out.println("2. Tickets");
            System.out.println("3. Magazines");
            System.out.println("99. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    ticketMenu();
                    break;
                case 3:
                    magazineMenu();
                    break;
                case 99:
                    cT.showTotal();
                    run = false;

            }
        }
    }
//Book Menu Methods

    public void bookMenu() {
        boolean go = true;

        while (go == true) {
            System.out.println("------Books------");
            System.out.println("1. View Books");
            System.out.println("2. Add Books");
            System.out.println("3. Edit Books");
            System.out.println("4. Delete Books");
            System.out.println("5. Sell Books");
            System.out.println("6. Quit");
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
                case 5:
                    sellBook();
                    break;
                case 6:
                    go = false;
            }
        }
    }

    private void addBook() {
        boolean add = true;

        while (add == true) {

            System.out.println("Enter the title:");
            input.nextLine();
            String title = input.nextLine();
            System.out.println("Price:");
            double price = input.nextDouble();
            System.out.println("Enter the author:");
            input.nextLine();
            String author = input.nextLine();
            System.out.println("Quantity to order:");
            int copies = input.nextInt();

            b.add(new Book(title, price, author, copies));
            break;

        }
    }

    private void editBook() {
        if (!b.isEmpty()) {
            boolean add = true;
            int size = b.size();
            while (add == true) {
                boolean bookEdit = true;
                System.out.println("Select a book:");
                for (int i = 0; i < size; i++) {
                    System.out.println(i + 1 + ". " + b.get(i).getTitle());
                }
                System.out.println(size + 1 + ". Exit ");
                int bookNum = input.nextInt();
                if (bookNum == size + 1) {
                    add = false;
                    break;
                }
                while (bookEdit == true) {
                    System.out.println("Select an editing option");
                    System.out.println("1. Edit Title");
                    System.out.println("2. Edit Price");
                    System.out.println("3. Edit Author");
                    System.out.println("4. Edit Copies");
                    System.out.println("5. Exit Book Editor");
                    int select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.print("Current title: ");
                            System.out.println(b.get(bookNum - 1).getTitle());
                            System.out.println("\nEnter a new title:");
                            input.nextLine();
                            String title = input.nextLine();
                            b.get(bookNum - 1).setTitle(title);
                            break;
                        case 2:
                            System.out.print("Current price: ");
                            System.out.println(b.get(bookNum - 1).getPrice());
                            System.out.println("\nEnter a new price:");
                            float price = input.nextFloat();
                            b.get(bookNum - 1).setPrice(price);
                            break;
                        case 3:
                            System.out.print("Current author's name: ");
                            System.out.println(b.get(bookNum - 1).getAuthor());
                            System.out.println("\nEnter a new author's name:");
                            input.nextLine();
                            String author = input.nextLine();
                            b.get(bookNum - 1).setAuthor(author);
                            break;
                        case 4:
                            System.out.print("Current number of copies on order: ");
                            System.out.println(b.get(bookNum - 1).getCopies());
                            System.out.println("\nEnter a new number of copies:");
                            int qty = input.nextInt();
                            b.get(bookNum - 1).setCopies(qty);
                            break;

                        case 5:
                            bookEdit = false;

                    }
                }
            }
        } else {
            System.out.println("There are no books available");
        }
    }

    private void deleteBook() {
        if (!b.isEmpty()) {
            System.out.println("Select a book to remove from inventory:");
            for (int i = 0; i < b.size(); i++) {
                System.out.println(i + 1 + ". " + b.get(i).getTitle());
            }
            System.out.println(b.size() + 1 + ". Exit ");
            delete = input.nextInt();
            if (delete == b.size() + 1) {

            } else {
                b.remove(delete - 1);
            }
            compressBooks(0);
        } else {
            System.out.println("There are no books available");
        }
    }

    private void viewBook() {
        if (!b.isEmpty()) {
            for (int i = 0; i < b.size(); i++) {
                System.out.println(b.get(i));
            }
        } else {
            System.out.println("There are no books available");
        }
    }

    private void sellBook() {
        if (!b.isEmpty()) {
            System.out.println("Select a book to sell:");
            for (int i = 0; i < b.size(); i++) {
                System.out.println(i + 1 + ". " + b.get(i).getTitle());
            }
            System.out.println(b.size() + 1 + ". Exit ");
            delete = input.nextInt();
            if (delete == b.size() + 1) {

            } else {
                cT.sellItem(b.get(delete - 1));
            }
            if (b.get(delete - 1).getCopies() == 0) {
                b.remove(delete - 1);
            }
            compressBooks(0);
        } else {
            System.out.println("There are no books available");
        }
    }

    private void compressBooks(int i) {
        if (delete >= b.size() - 1) {
            return;
        }
        while (i != b.size() - 1 && delete < b.size() - 1) {
            if (b.get(i) == null && b.get(i + 1) != null) {
                b.set(i, b.get(i + 1));
                b.remove(i + 1);
            }
            compressBooks(i + 1);
        }
        compressBooks(0);
    }
//Ticket Menu

    public void ticketMenu() {
        boolean go = true;
        Ticket t = new Ticket();
        while (go == true) {
            System.out.println("------Tickets------");
            System.out.println("1. Sell Ticket");
            System.out.println("2. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    cT.sellItem(t);
                    System.out.println(t.toString());
                case 2:
                    go = false;
            }
        }
    }

//Magazine Menu and Methods
    public void magazineMenu() {
        boolean go = true;
        while (go == true) {
            System.out.println("------Books------");
            System.out.println("1. View Magazines");
            System.out.println("2. Add Magazines");
            System.out.println("3. Edit Magazines");
            System.out.println("4. Delete Magazines");
            System.out.println("5. Sell Magazines");
            System.out.println("6. Quit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewMag();
                    break;
                case 2:
                    addMag();
                    break;
                case 3:
                    editMag();
                    break;
                case 4:
                    deleteMag();
                    break;
                case 5:
                    sellMag();
                    break;
                case 6:
                    go = false;
            }
        }
    }

    private void viewMag() {
        if (!m.isEmpty()) {
            for (int i = 0; i < m.size(); i++) {
                System.out.println(m.get(i));
            }
        } else {
            System.out.println("There are no magazines available");
        }
    }

    private void addMag() {
        boolean add = true; //Title, price, copies, order, date

        while (add == true) {

            System.out.println("Enter the Title: ");
            input.nextLine();
            String title = input.nextLine();
            System.out.println("Enter the Price: ");
            double prices = input.nextDouble();

            System.out.println("Number of Copies: ");
            int copies = input.nextInt();

            System.out.println("Order QTY: ");
            int QTY = input.nextInt();

            System.out.println("Input a Date(" + datePattern + "): ");
            String dateGrab = input.next();

            try {
                Date magDate = date.parse(dateGrab);
                m.add(new Magazine(title, prices, copies, QTY, magDate));
                break;
            } catch (ParseException e) {
                System.out.println("Invalid Date");
            }
        }
    }

    private void editMag() {
        if (!m.isEmpty()) {
            boolean add = true;
            int size = m.size();
            while (add == true) {
                boolean bookEdit = true;
                System.out.println("Select a book:");
                for (int i = 0; i < size; i++) {
                    System.out.println(i + 1 + ". " + m.get(i).getTitle());
                }
                System.out.println(size + 1 + ". Exit ");
                int magNum = input.nextInt();
                if (magNum == size + 1) {
                    add = false;
                    break;
                }
                while (bookEdit == true) {//Title, price, copies, order, date
                    System.out.println("Select an editing option");
                    System.out.println("1. Edit Title");
                    System.out.println("2. Edit Price");
                    System.out.println("3. Edit Copies");
                    System.out.println("4. Edit Order Quantities");
                    System.out.println("5. Edit Date");
                    System.out.println("6. Exit");
                    int select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.print("Current title: ");
                            System.out.println(m.get(magNum - 1).getTitle());
                            System.out.println("\nEnter a new title:");
                            input.nextLine();
                            String title = input.nextLine();
                            m.get(magNum - 1).setTitle(title);
                            break;
                        case 2:                                 //Title, price, copies, order, date
                            System.out.print("Current price: ");
                            System.out.println(m.get(magNum - 1).getPrice());
                            System.out.println("\nEnter a new price:");
                            double price = input.nextDouble();
                            m.get(magNum - 1).setPrice(price);
                            break;
                        case 3:
                            System.out.print("Current number of copies: ");
                            System.out.println(m.get(magNum - 1).getCopies());
                            System.out.println("\nEnter a new number of copies: ");
                            int copies = input.nextInt();
                            m.get(magNum - 1).setCopies(copies);
                            break;
                        case 4:
                            System.out.print("Current order quantity: ");
                            System.out.println(m.get(magNum - 1).getOrderQTY());
                            System.out.println("\nEnter a new order quantity:");
                            int qty = input.nextInt();
                            m.get(magNum - 1).adjustQTY(qty);
                            break;
                        case 5:
                            System.out.print("Current issue date: ");
                            System.out.println(date.format(m.get(magNum - 1).getCurrIssue()));
                            System.out.println("\nEnter a new issue date:");
                            String dateGrab = input.next();
                            try {
                                Date magDate = date.parse(dateGrab);
                                m.get(magNum - 1).recvNewIssue(magDate);
                            } catch (ParseException e) {
                                System.out.println("Invalid Date");
                            }
                            break;
                        case 6:
                            bookEdit = false;
                    }
                }
            }
        } else {
            System.out.println("There are no magazines available");
        }
    }

    private void deleteMag() {
        if (!m.isEmpty()) {
            System.out.println("Select a magazine to sell:");
            for (int i = 0; i < m.size(); i++) {
                System.out.println(i + 1 + ". " + m.get(i).getTitle());
            }
            System.out.println(m.size() + 1 + ". Exit ");
            delete = input.nextInt();
            if (delete == m.size() + 1) {

            } else {
                m.remove(delete - 1);
            }
            compressMags(0);
        } else {
            System.out.println("There are no magazines available");
        }
    }

    private void sellMag() {
        if (!m.isEmpty()) {
            System.out.println("Select a magazine to sell:");
            for (int i = 0; i < m.size(); i++) {
                System.out.println(i + 1 + ". " + m.get(i).getTitle());
            }
            System.out.println(m.size() + 1 + ". Exit ");
            delete = input.nextInt();
            if (delete == m.size() + 1) {

            } else {
                cT.sellItem(m.get(delete - 1));
            }
            if (m.get(delete - 1).getCopies() == 0) {
                m.remove(delete - 1);
            }
            compressBooks(0);
        } else {
            System.out.println("There are no magazines available");
        }
    }
    
    private void compressMags(int i) {
        if (delete >= m.size() - 1) {
            return;
        }
        while (i != m.size() - 1 && delete < m.size() - 1) {
            if (m.get(i) == null && m.get(i + 1) != null) {
                m.set(i, m.get(i + 1));
                m.remove(i + 1);
            }
            compressMags(i + 1);
        }
        compressMags(0);
    }
}
