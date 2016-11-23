package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author nickl
 */
@Entity
public class FlightInfo {
    
    @Id
    private String flightId;
    
    private String flightNumber;
    
    //date+time
    private String date;
    
    private int numOfSeats;
    
    private int totPrice;
    private String currency;
    
    //this variable is travel time in minutes!
    private int travelTime;
    
    //this is the depature airport!
    private String origin;
    
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

    public String getCurrency() {
        return currency;
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

