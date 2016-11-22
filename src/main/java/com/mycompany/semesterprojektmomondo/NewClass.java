package com.mycompany.semesterprojektmomondo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nicolaicornelis
 */
public class NewClass {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SemesterProjektMomondo");
        
//        EntityManager em = emf.createEntityManager();
    }
    
    
    
}
