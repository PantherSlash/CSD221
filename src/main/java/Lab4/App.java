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
        List<Book> b = new ArrayList<Book>();
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
        List<Magazine> m = new ArrayList<Magazine>();
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
}
