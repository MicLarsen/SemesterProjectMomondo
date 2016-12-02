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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author nickl
 */
@Ignore
public class BookingJPATest {

    static EntityManagerFactory emf;
    static FlightInfo fi;
    static List<BookingInfo> listOfDummyBookings = new ArrayList();
    static List<FlightInfo> listOfDummyFlights = new ArrayList();
    
    static BookingInfo biObj;

    public BookingJPATest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("SemesterProjektMomondo");
        fi = initDummyFlight();
        biObj = initDummyBooking();
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

        BookingInfo bi = new BookingInfo("test", new ArrayList(), "12345678", "test@test.com", fi);
        
        listOfDummyBookings.add(bi);

        BookingJPA instance = new BookingJPA(emf);

        BookingInfo expResult = bi;
        BookingInfo result = instance.insertBookingInf(bi);
        System.out.println("testInsertBookingInf Inserted Booking: " + result.getId());
        assertEquals(expResult.getReserveeName(), result.getReserveeName());
        assertEquals(expResult.getReserveeEmail(), result.getReserveeEmail());
    }

    /**
     * Test of retrieveBookingInf method, of class BookingJPA.
     */
    @Test
    public void testRetrieveBookingInf() {
        System.out.println("retrieveBookingInf");
        
        String email = biObj.getReserveeEmail();
        String flightNumber = fi.getFlightNumber();

        BookingJPA instance = new BookingJPA(emf);
        BookingInfo expResult = biObj;
        BookingInfo result = instance.retrieveBookingInf(email, flightNumber);
        assertEquals(expResult.getReserveeEmail(), result.getReserveeEmail());

    }

    
    //Initializing and Inserting a flight for use in bookingInfo objects!
    private static FlightInfo initDummyFlight() {

        String flightId = "2257-1457179200000";
        String flightNumber = "COL2257";
        String date = "2016-03-05T13:00:00.000Z";
        int seats = 3;
        int price = 180;
        int travelTime = 120;
        String origin = "CDG";
        String destination = "CPH";

        FlightInfo fi = new FlightInfo(flightId, flightNumber, date, seats, price, travelTime, origin, destination);

        FlightsJPA fjpa = new FlightsJPA(emf);
        listOfDummyFlights.add(fi);
        fjpa.insertFlightInf(fi);
        System.out.println("initDummyFlight Inserted Flight: " + fi.getFlightId());
        return fi;
    }

    //Initializing and Inserting a BookingInfo for use in tests excluding testInsertBookingInf
    private static BookingInfo initDummyBooking(){
        
        String reserveeName = "RetrieveTest";
        List<Person> passengers = new ArrayList();
        String reserveePhone = "22345678";
        String reserveeEmail = "retrieve@test.com";
        
        BookingInfo bookingInfo = new BookingInfo(reserveeName, passengers, reserveePhone, reserveeEmail, fi);
        listOfDummyBookings.add(bookingInfo);
        BookingJPA bjpa = new BookingJPA(emf);
        bjpa.insertBookingInf(bookingInfo);
        System.out.println("initDummyBooking Inserted Booking: " + bookingInfo.getId());
        return bookingInfo;
    }
    
    
    //Removes all entities inserted during tests 
    private static void cleanupDataBase() {
        System.out.println("cleanupDataBase");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            System.out.println("Removing amount of bookings: " + listOfDummyBookings.size());
            for(BookingInfo obj : listOfDummyBookings){
                BookingInfo doRemove = em.find(BookingInfo.class, obj.getId());
                em.remove(doRemove);
                System.out.println("Booking removed: " + obj.getId());
            }
            
            System.out.println("Removing amount of flights: " + listOfDummyFlights.size());
            for(FlightInfo obj :  listOfDummyFlights){
                FlightInfo doRemove = em.find(FlightInfo.class, obj.getFlightId());
                em.remove(doRemove);
                System.out.println("Flight removed: " + obj.getFlightId());
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("cleanupDataBase failed due to: " + e.getCause() + e.getLocalizedMessage());
            transaction.rollback();
        } finally {
            em.close();
        }
    }

}
