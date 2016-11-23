package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nickl
 */
@Entity
public class FlightInfo {
    
    @Id
    private String flightId;
    
    private String flightNumber;
    
    private String date;  //date as string in iso-8601 format
    
    private int numOfSeats;
    
    private int totPrice;
    
    private int travelTime;  //date as string in iso-8601 format
    
    private String origin;  //this is the depature airport!
    
    private String destination;
    
    
    public FlightInfo(){}
    
    public FlightInfo(String flightId, String flightNumber, String date, int numOfSeats, int totalPrice, int travelTime, String origin, String destination){
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numOfSeats = numOfSeats;
        this.totPrice = totalPrice;
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDate() {
        return date;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public int getTotPrice() {
        return totPrice;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}

