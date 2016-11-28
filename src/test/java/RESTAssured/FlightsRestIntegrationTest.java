package RESTAssured;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Ignore;

/**
 *
 * @author nickl
 */
public class FlightsRestIntegrationTest {

    public FlightsRestIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/SemesterProjektMomondo";
        RestAssured.defaultParser = Parser.JSON;
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

    //Checking that the server has been deployed and is running
//    @Ignore
    @Test
    public void connectionTest(){
        when().get("/").then().statusCode(200);
    }
    
//    @Ignore
    @Test
    public void getJsonTest() {
        String airline = "gruppe4";
        String flightID = "2257-1457179200000";
        String flightNumber = "COL2257";
        String date = "2016-03-05T13:00:00.000Z";
        int numberOfSeats = 3;
        int totalPrice = 180;
        int traveltime = 120;
        String origin = "CDG";
        String destination = "CPH";
        
        when().get("/api/flights/test/test/2")
                .then().statusCode(200).
                body("airline", equalTo(airline)).
                body("flights[0].flightID", equalTo(flightID)).
                body("flights[0].flightNumber", equalTo(flightNumber)).
                body("flights[0].date", equalTo(date)).
                body("flights[0].numberOfSeats", equalTo(numberOfSeats)).
                body("flights[0].totalPrice", equalTo(totalPrice)).
                body("flights[0].traveltime", equalTo(traveltime)).
                body("flights[0].origin", equalTo(origin)).
                body("flights[0].destination", equalTo(destination));
    }
}
