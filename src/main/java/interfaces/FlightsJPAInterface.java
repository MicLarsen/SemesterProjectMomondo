package interfaces;

import entities.FlightInfo;

/**
 *
 * @author nickl
 */
public interface FlightsJPAInterface {
    
    public String insertFlightInf(FlightInfo fi);
    
    public FlightInfo retrieveFlightInf(String flightNumber);
    
    public FlightInfo updateFlightInf(FlightInfo fi);
    
    public boolean deleteFlightInf(FlightInfo fi);
}
