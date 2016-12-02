package S2S;

import interfaces.S2SInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONArray;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author Michael
 */
public class AirlineInfo implements S2SInterface {

    private int responseCode;
    private JSONObject responseJSONData;
    StringBuffer response = new StringBuffer();
    private final String USER_AGENT = "Group 4A - 3. semesterProject 2016";
    private final String AngularJSAirlineURL = "http://airline-plaul.rhcloud.com/api/";

    public AirlineInfo() {
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
    @Override
    public String getAirlineData(String from, String date, int numberOfSeats) {
        InputStream inputStream = null;

        try {
            inputStream = new URL(AngularJSAirlineURL + "flightinfo/"+ from + "/" + date + "/" + numberOfSeats).openStream();
            try {
                BufferedReader response = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String responseString = convertToString(response);
                responseJSONData = new JSONObject(responseString);

            } finally {
                inputStream.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseJSONData.toString();
    }

    /**
     * Fetching from Lars' airline js
     * @param from
     * @param to
     * @param date
     * @param numberOfSeats
     * @return 
     */
    @Override
    public String getJsonFromServer(String from, String to, String date, int numberOfSeats) {
        InputStream inputStream = null;

        try {
            inputStream = new URL(AngularJSAirlineURL + "flightinfo/" + from + "/" + date + "/" + numberOfSeats).openStream();
            try {
                BufferedReader response = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String responseString = convertToString(response);
                responseJSONData = new JSONObject(responseString);

            } finally {
                inputStream.close();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sortFromTo(responseJSONData, to).toString();
    }
    
    /**
     * Fetching from out costum airline - need to change the URL:
     * @param object
     * @return 
     */
//    @Override
//    public String getJsonFromServer(String from, String to, String date, int numberOfSeats) {
//        InputStream inputStream = null;
//        try {
//            inputStream = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + to + "/" + date +"/"+numberOfSeats).openStream();
//            try {
//                BufferedReader response = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//                String responseString = convertToString(response);
//                responseJSONData = new JSONObject(responseString);
//
//            } finally {
//                inputStream.close();
//            }
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(AirlineInfo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return sortFromTo(responseJSONData, to).toString();
//    }

//    public String bookTickets(String flightId, int tickets, List<String> persons) {
    @Override
    public String bookTickets(String object) {
        try {
            String url = AngularJSAirlineURL + "flightreservation";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String urlParameters = object.toString(); // JSONObject insertes here

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        } catch (Exception e) {

            if (responseCode < 500 && responseCode >= 400) {
                return response.toString();
            }
            if (responseCode >= 500) {
                return response.toString();
            }
        }
        return response.toString();
    }

    private JSONObject sortFromTo(JSONObject object, String destination) {

        JSONObject returnObj = new JSONObject();
        JSONArray flightsArray = new JSONArray();

        returnObj.put("airline", object.get("airline"));
        for (int i = 0; i < object.getJSONArray("flights").length(); i++) {
            if (object.getJSONArray("flights").getJSONObject(i).get("destination").equals(destination)) {
                flightsArray.put(object.getJSONArray("flights").getJSONObject(i));
            }
        }
        returnObj.put("flights", flightsArray);

        return returnObj;
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

    /**
     * JSON – Object
     *
     * {
     * "flightID": String, "numberOfSeats": Integer, "reserveeName": String,
     * "reservePhone": String, "reserveeEmail": String (valid email),
     * "passengers":[ { "firstName":String, "lastName": String } ] }
     *
     * @param args
     */
    public static void main(String[] args) {

        AirlineInfo ai = new AirlineInfo();
        System.out.println(ai.getJsonFromServer("CPH", "SXF", "2017-01-04T00:00:00.000Z", 2));

    }

}
