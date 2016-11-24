package S2S;

import interfaces.S2SInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Michael
 */
public class AirlineInfo implements S2SInterface, Runnable {

    @Override
    public JSONObject getJsonFromServer(String from, String date, int tickets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject getJsonFromServer(String from, String to, String date, int tickets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bookTickets(String flightId, int tickets, List<String> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param rd
     * @return
     * @throws IOException 
     */
    private static String readAll(Reader inputString){
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            while ((cp = inputString.read()) != -1) {
                sb.append((char) cp);
            }
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    /**
     *
     * @param url: contacts dummy airline company at:
     * 'http://airline-plaul.rhcloud.com/api/flightinfo'
     * 
     * @airportTag : chosen tag of the departing airport (Origin) 
     * @timeStamp : chosen time of departure (date)
     * @numberOfSeats : chosen number of seats (numberOfSeats)
     * 
     * @return returns JSONObject with data for specified flights
     */
    //remove static before deploy
    public static JSONObject getAirlineData(String airportTag, String timeStamp, String numberOfSeats) {
        InputStream is = null;
        JSONObject json;
        try {
            is = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" + airportTag + "/" + timeStamp + "/" + numberOfSeats).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String JSONString = readAll(rd);
                json = new JSONObject(JSONString);
                return json;
            } finally {
                is.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException, JSONException {
        org.json.JSONObject json = getAirlineData("CPH", "2017-02-01T00:00:00.000Z", "2");
        System.out.println(json.toString());
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
