package JPA;

import entities.BookingInfo;
import interfaces.BookingJPAInterface;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author nickl
 */
public class BookingJPA implements BookingJPAInterface {

    EntityManager em;

    public BookingJPA(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public BookingInfo insertBookingInf(BookingInfo bi) {
        try {
            em.getTransaction().begin();
            em.merge(bi);
            em.getTransaction().commit();

            return bi;
        } catch (Exception e) {
            System.out.println("BookingJPA.insertBookingInfo stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public BookingInfo retrieveBookingInf(String email, String flightNumber) {
        BookingInfo returnObj;
        try {
            em.getTransaction().begin();

            Query q = em.createQuery("SELECT b FROM BookingInfo b, FlightInfo f WHERE b.reserveeEmail=:email AND f.flightNumber=:fNum", BookingInfo.class);
            q.setParameter("email", email);
            q.setParameter("fNum", flightNumber);

            returnObj = (BookingInfo) q.getSingleResult();

            em.getTransaction().commit();

            return returnObj;
        } catch (Exception e) {
            System.out.println("BookingJPA.retrieveBookingInfo stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public BookingInfo updateBookingInf(BookingInfo bi) {
        try {
            em.getTransaction().begin();
            em.merge(bi);
            em.getTransaction().commit();
            return bi;
        } catch (Exception e) {
            System.out.println("BookingJPA.updateFlightInfo stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean deleteBookingInf(BookingInfo bi) {
        try {
            em.getTransaction().begin();
            em.remove(bi);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("BookingJPA.deleteFlightInfo stopped due to : " + e.getCause());
            em.getTransaction().rollback();
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            em.close();
            return true;
        } catch(Exception e){
            System.out.println("BookingJPA.closeConnection stopped due to : " + e.getCause());
            return false;
        }
    }
    
}
