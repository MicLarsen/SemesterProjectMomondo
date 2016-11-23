package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author Michael
 * @Path: 'flights' is the root-path for REST-calls
 */
@Path("flights")
public class Flights {

    @Context
    private UriInfo context;

    public Flights() {
    }

    /**
     * Retrieves representation of an instance of rest.Flights
     * @return an instance of java.lang.String
     * 
     * JSON OBJECT {  
   "airline":String,
   "flights":[  
      {  
         "flightID": String,
         "flightNumber" : String
         "date": ISO-8601 String (date+time),
         "numberOfSeats": Integer,
         "totalPrice": Number (Euro),
         "traveltime": Integer (minutes),
         "origin":"IATA-Code (String),
         "destination": IATA-Code (String)
      }
   ],...
   * 
   * Example

{
  "airline": "AngularJS Airline",
  "flights": [
    {
      "flightID": "2257-1457179200000",
      "flightNumber": "COL2257",
      "date": "2016-03-05T13:00:00.000Z",
      "numberOfSeats": 3,
      "totalPrice": 180,
      "traveltime": 120,
      "origin": "CDG",
      "destination": "CPH",
    }
  ]
}

}

     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{from}/{date}/{tickets}")
    public String getJson(@PathParam("from") String from ,@PathParam("date") String date ,@PathParam("tickets") String ticket ) {
        
        JSONObject obj = new JSONObject(); 
        
        obj.put("airline" , "gruppe4");
        
        JSONArray flights = new JSONArray();
        
        JSONObject aFlight = new JSONObject();
        
        aFlight.put("flightID", "2257-1457179200000");
        aFlight.put("flightNumber", "COL2257");
        aFlight.put("date",  "2016-03-05T13:00:00.000Z");
        aFlight.put("numberOfSeats", 3);
        aFlight.put("totalPrice", 180);
        aFlight.put("traveltime", 120);
        aFlight.put("origin", "CDG");
        aFlight.put("destination", "CPH");
        
        flights.add(aFlight);
        
        obj.put("flights" ,flights);

        return obj.toString();
//
//Parameters:
//from:  Start Airport (as  an IATA Code)
//date: Travel date (as a ISO-8601 date)
//tickets : Requested amount of tickets (integer)

    }

    /**
     * PUT method for updating or creating an instance of Flights
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
