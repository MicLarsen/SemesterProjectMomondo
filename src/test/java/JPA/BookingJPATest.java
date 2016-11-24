package JPA;

import entities.BookingInfo;
import entities.FlightInfo;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickl
 */
public class BookingJPATest {

    static EntityManagerFactory emf;
    static FlightInfo fi;
    static List<Object> listOfTestItems = new ArrayList();
    BookingInfo bi;

    public BookingJPATest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("SemesterProjektMomondo");
        fi = initDummyFlight();
    }

    @AfterClass
    public static void tearDownClass() {
        cleanupDataBase();
        emf.close();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertBookingInf method, of class BookingJPA.
     */
    @Test
    public void testInsertBookingInf() {
        System.out.println("insertBookingInf");

        String reserveeName = "test";
        List<Person> passengers = new ArrayList();
        String reserveePhone = "12345678";
        String reserveeEmail = "test@test.com";

        bi = new BookingInfo(reserveeName, passengers, reserveePhone, reserveeEmail, fi);
        listOfTestItems.add(bi);

        BookingJPA instance = new BookingJPA(emf);

        BookingInfo expResult = bi;
        BookingInfo result = instance.insertBookingInf(bi);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveBookingInf method, of class BookingJPA.
     */
    @Test
    public void testRetrieveBookingInf() {
        System.out.println("retrieveBookingInf");
        String email = "test@test.com";
        String flightNumber = fi.getFlightNumber();

        BookingJPA instance = new BookingJPA(emf);
        BookingInfo expResult = bi;
        BookingInfo result = instance.retrieveBookingInf(email, flightNumber);
        assertEquals(expResult, result);

    }

    private static FlightInfo initDummyFlight() {

        String flightId = "2257-1457179200000";
        String flightNumber = "COL2257";
        String date = "2016-03-05T13:00:00.000Z";
        int seats = 3;
        int price = 180;
        int traveltime = 120;
        String origin = "CDG";
        String destination = "CPH";

        FlightInfo fi = new FlightInfo(flightId, flightNumber, date, seats, price, traveltime, origin, destination);

        FlightsJPA fjpa = new FlightsJPA(emf);
        listOfTestItems.add(fi);
        fjpa.insertFlightInf(fi);
        return fi;
    }

    private static void cleanupDataBase() {
        System.out.println("cleanupDataBase");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Query q1 = em.createQuery("DELETE FROM Person");
            Query q2 = em.createQuery("DELETE FROM BookingInfo");
            Query q3 = em.createQuery("DELETE FROM FlightInfo");

            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            System.out.println("cleanupDataBase failed due to: " + e.getCause());
            transaction.rollback();
        } finally {
            em.close();
        }
    }

}
