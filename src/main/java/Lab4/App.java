/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

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
                System.out.println(t.sellCopy());
            case 2: go = false;
        }
        }
    }
    
    public void magazineMenu(){
        
    }
}
