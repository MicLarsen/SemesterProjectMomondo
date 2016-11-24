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
    @Override
    public JSONObject getAirlineData(String airportTag, String date, int numberOfSeats) {
        InputStream inputStream = null;
        JSONObject responseJSONData;
        try {
            inputStream = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" + airportTag + "/" + date + "/" + numberOfSeats).openStream();
            try {
                BufferedReader response = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String responseString = convertToString(response);
                responseJSONData = new JSONObject(responseString);
                return responseJSONData;
            } finally {
                inputStream.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public JSONObject getJsonFromServer(String from, String to, String date, int tickets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bookTickets(String flightId, int tickets, List<String> persons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param inputString
     * @return
     * @throws IOException
     */
    private String convertToString(Reader inputString) {
        StringBuilder stringBuilder = new StringBuilder();
        int k;
        try {
            while ((k = inputString.read()) != -1) {
                stringBuilder.append((char) k);
            }
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringBuilder.toString();
    }
}
