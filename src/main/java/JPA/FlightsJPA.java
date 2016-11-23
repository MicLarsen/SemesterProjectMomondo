package JPA;

import entities.FlightInfo;
import interfaces.FlightsJPAInterface;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author nickl
 */
public class FlightsJPA implements FlightsJPAInterface {

    
    //TODO::::::!!!!!!!!
    //Create a localhost persistence unit!!!!!! for testing puposes!
    
    private EntityManager em;

    public FlightsJPA(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public String insertFlightInf(FlightInfo fi) {
        try {
            em.getTransaction().begin();

            em.persist(fi);

            em.getTransaction().commit();

            return fi.getFlightId();
        } catch (Exception e) {
            System.out.println("FlightsJPA.insertFlightInfo stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return e.getMessage();
        }
    }

    @Override
    public FlightInfo retrieveFlightInf(String flightId) {
        FlightInfo returnObj;

        try {
            em.getTransaction().begin();

            returnObj = em.find(FlightInfo.class, flightId);

            em.getTransaction().commit();

            return returnObj;
        } catch (Exception e) {
            System.out.println("FlightsJPA.retrieveFlightInf stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public FlightInfo updateFlightInf(FlightInfo fi) {
        try {
            em.getTransaction().begin();
            em.equals(fi);
            em.merge(fi);

            em.getTransaction().commit();

            return fi;
        } catch (Exception e) {
            System.out.println("FlightsJPA.updateFlightInf stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public boolean deleteFlightInf(FlightInfo fi) {
        try {
            em.getTransaction().begin();

            em.remove(fi);

            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            System.out.println("FlightsJPA.updateFlightInf stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            em.close();
            return true;
        } catch(Exception e){
            System.out.println("FlightsJPA.closeConnection stopped due to : " + e.getCause());
            return false;
        }
    }
}
