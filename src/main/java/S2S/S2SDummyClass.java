package S2S;

import interfaces.S2SInterface;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author nickl
 */
public class S2SDummyClass implements S2SInterface {

    @Override
    public JSONObject getJsonFromServer(String from, String date, int tickets) {
        JSONObject json = new JSONObject();
        json.put("from: ", from);
        json.put("date: ", date);
        json.put("tickets: ", tickets);

        return json;
    }

    @Override
    public JSONObject getJsonFromServer(String from, String to, String date, int tickets) {
        JSONObject json = new JSONObject();
        json.put("from: ", from);
        json.put("to: ", to);
        json.put("date: ", date);
        json.put("tickets: ", tickets);

        return json;
    }

    @Override
    public String bookTickets(String flightId, int tickets, List<String> persons) {
        String personsAsString = "";

        for (String personInf : persons) {
            personsAsString += personInf;
        }

        return "flightid: " + flightId + ", tickets: " + tickets + ", personlist: " + personsAsString;
    }
}
