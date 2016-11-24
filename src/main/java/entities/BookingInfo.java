package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private FlightInfo flightInfo;
    
    private int numOfSeats;
    
    private String reserveeName;
    
    private String reserveePhone;
    
    private String reserveeEmail;
    
    @OneToMany(mappedBy = "bookingInfo")
    private List<Person> passengers;
    
    public BookingInfo(){}
    
    public BookingInfo(String reserveeName, List<Person> passengers, String reserveePhone, String reserveeEmail){
        this.reserveeName = reserveeName;
        this.reserveePhone = reserveePhone;
        this.reserveeEmail = reserveeEmail;
        this.passengers = passengers;
    }
    
    public BookingInfo(String reserveeName, List<Person> passengers, String reserveePhone, String reserveeEmail, FlightInfo fi){
        this.reserveeName = reserveeName;
        this.reserveePhone = reserveePhone;
        this.reserveeEmail = reserveeEmail;
        this.passengers = passengers;
        this.flightInfo = fi;
    }

    public int getId() {
        return id;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getReserveeName() {
        return reserveeName;
    }

    public String getReserveePhone() {
        return reserveePhone;
    }

    public String getReserveeEmail() {
        return reserveeEmail;
    }

    public List<Person> getPassengers() {
        return passengers;
    }
    
    
}
