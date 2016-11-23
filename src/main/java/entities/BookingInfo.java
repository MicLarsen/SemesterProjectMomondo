package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nickl
 */
@Entity
public class BookingInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //database id!
    
    private String flightNumber;
    
    //departure airport
    private String origin;
    
    private String destination;
    
    //date as string in iso-8601 format
    private String date;
    
    //flight time in minutes!
    private int flightTime;
    
    private int numOfSeats;
    
    private String reserveeName;
    
    @OneToMany(mappedBy = "bookingInfo")
    private List<Person> passengers;
    
    public BookingInfo(){}
    
    public BookingInfo(String flightNumber, String origin, String destination, String date, int flightTime, int numOfSeats, String reserveeName, List<Person> passengers){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.flightTime = flightTime;
        this.numOfSeats = numOfSeats;
        this.reserveeName = reserveeName;
        this.passengers = passengers;
    }
}
