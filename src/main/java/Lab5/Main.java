/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lab5.controllers.*;

import lab5.entities.*;

/**
 *
 * @author Kodi Kahtava
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        String datePattern = "MMM-dd-yyyy";
        SimpleDateFormat date = new SimpleDateFormat(datePattern);
        try{
            emf=Persistence.createEntityManagerFactory("CashTillPU");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();
            Book book=new Book();
            Magazine mag=new Magazine();
            
            book.setAuthor("Kodi Kahtava");
            book.setTitle("How to Write Kode");
            book.setPrice(19.99);
            book.setCopies(15);
            
            mag.setOrderQTY(20);
            mag.setTitle("Kodi's Coding Magazine");
            mag.setCurrIssue((java.sql.Date) date.parse("MAR-15-2017"));
            mag.setCopies(20);
            
            em.persist(book);
            em.persist(mag);
            em.getTransaction().commit();
            
            List<Publication> ListOfPublications = em.createQuery("SELECT c FROM Publication c").getResultList();
            System.out.println("List of Publications");
            for(Publication customer:ListOfPublications){
                System.out.println(customer.getTitle());
            }
            List<Book> ListOfBooks = em.createQuery("SELECT c FROM Book c").getResultList();
            System.out.println("List of Books");
            for(Book customer:ListOfBooks){
                System.out.println(customer.getTitle());
            }
            List<Magazine> ListOfMagazines = em.createQuery("SELECT c FROM Magazine c").getResultList();
            System.out.println("List of Magazines");
            for(Magazine customer:ListOfMagazines){
                System.out.println(customer.getTitle());
            }
            
            
            // use controllers
            BookJpaController bookController=new BookJpaController(emf);
            Book book2=new Book();
            book2.setAuthor("Kodi Kahtava");
            book2.setTitle("How to Write Two Books");
            bookController.create(book2);
            
            ListOfBooks=bookController.findBookEntities();
            for(Book b:ListOfBooks){
                System.out.println(b.getTitle());
            }
            
            
        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
        }
    }

}
