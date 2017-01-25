/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATester;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import JPATestTables.Address;
import JPATestTables.Customer;
import JPATestTables.Employee;
import JPATestTables.Department;
import JPATestTables.ProductOrder;
/**
 *
 * @author Kodi Kahtava
 */
public class JPATester {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("JPATesterPU");
            em=emf.createEntityManager();
            Logger.getLogger(JPATester.class.getName()).log(Level.INFO, "Entity Manager created" + emf);
            em.getTransaction().begin();
            //testing information
            //Customer Information
            Customer k = new Customer();
            k.setName("Kodi Kahtava");
            k.setAge(19);
            k.setAddress(new Address());
            k.getAddress().setCity("Echo Bay");
            k.getAddress().setStreet("100 Elizabeth");
            k.getAddress().setState("Ontario");
            em.persist(k);
            //Employee Information
            Employee b = new Employee();
            b.setName("Bryton Stoneypoint");
            b.setAge(23);
            b.setAddress(new Address());
            b.getAddress().setCity("Sault Ste. Marie");
            b.getAddress().setStreet("44 Poverty Lane");
            b.getAddress().setState("Ontario");
            em.persist(b);
            em.getTransaction().commit();
            
            
        }catch(Exception e){
            Logger.getLogger(JPATester.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
  //         if(em!=null)
    //            em.close();
        }
    }

}
