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
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{tickets}")
    public String getJson(@PathParam("from") String from ,@PathParam("date") String date ,@PathParam("ticket") String ticket ) {
        JSONObject obj = new JSONObject(); 
        obj.put("from" , from); //        api/flights/:from/:date/:tickets
        obj.put("date" , date); //        api/flights/:from/:date/:tickets
        obj.put("ticket" , ticket); //        api/flights/:from/:date/:tickets
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
