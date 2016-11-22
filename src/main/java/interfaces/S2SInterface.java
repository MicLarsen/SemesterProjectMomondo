package interfaces;

import java.util.List;
import javax.json.Json;

/**
 *
 * @author nickl
 */
public interface S2SInterface {
    //Refactor with url parameter for multiple choices of airlines
    public Json getJsonFromServer(String from, String date, int tickets);
    
    public Json getJsonFromServer(String from, String to, String date, int tickets);
    
    //Persons should contain the personal information required to book the tickets!
    public String bookTickets(String flightId, int tickets, List<String> persons);
    
}
