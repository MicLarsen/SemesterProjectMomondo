package RESTAssured;

import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import rest.Flights;

/**
 *
 * @author Michael
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightsTest extends BaseRestTest {

    public FlightsTest() {
    }

    @Test
    public void callApi() {

        
        
        String airline = "gruppe4";
        String flightID = "2257-1457179200000";
        String flightNumber = "COL2257";
        String date = "2016-03-05T13:00:00.000Z";
        int numberOfSeats = 3;
        int totalPrice = 180;
        int traveltime = 120;
        String origin = "CDG";
        String destination = "CPH";

        when().
                get("/flights/" + origin + "/" + date + "/" + numberOfSeats).
                then().
                contentType(ContentType.JSON).
        body("airline", equalTo(airline)).
        body("flights[0].flightID", equalTo(flightID)).
        body("flights[0].flightNumber", equalTo(flightNumber)).
        body("flights[0].date", equalTo(date)).
        body("flights[0].numberOfSeats", equalTo(numberOfSeats)).
        body("flights[0].totalPrice", equalTo(totalPrice)).
        body("flights[0].traveltime", equalTo(traveltime)).
        body("flights[0].origin", equalTo(origin)).
        body("flights[0].destination", equalTo(destination));

//        aFlight.put("flightID", flightID);
//        aFlight.put("flightNumber", flightNumber);
//        aFlight.put("date", date);
//        aFlight.put("numberOfSeats", 3);
//        aFlight.put("totalPrice", 180);
//        aFlight.put("traveltime", 120);
//        aFlight.put("origin", "CDG");
//        aFlight.put("destination", "CPH");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
