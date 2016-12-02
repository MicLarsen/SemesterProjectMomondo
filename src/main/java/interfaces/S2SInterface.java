package interfaces;

import java.util.List;
import org.json.JSONObject;


/**
 *
 * @author nickl
 */
public interface S2SInterface {
    //Refactor with url parameter for multiple choices of airlines
    public String getAirlineData(String from, String date, int tickets);
    
    public String getJsonFromServer(String from, String to, String date, int tickets);
    
    //Persons should contain the personal information required to book the tickets!
    public String bookTickets(String bookingInfo);
    
}
