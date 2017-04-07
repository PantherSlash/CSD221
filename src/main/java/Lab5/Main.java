/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;


import Lab5.Entities.Publication;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author fcarella
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("JPATester_mvn_PU");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();
            Publication c=new Publication() {};
            
            
            List<Publication> ListOfPublications = em.createQuery("SELECT c FROM Publication c").getResultList();
            System.out.println("List of Publications");
            for(Publication customer:ListOfPublications){
                System.out.println(customer.getName());
            }
            
        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
//            if(em!=null)
//                em.close();
        }
    }

}
