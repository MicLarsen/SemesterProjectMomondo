package RESTAssured;

import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Michael
 */
public class FlightsTest extends BaseRestTest{
    
    
    
    public FlightsTest() {
    }
    
    @Test
    public void callApi() {
      
        when().
                get("/flights").
                then().
                contentType(ContentType.JSON).
                body("result" , equalTo("success"));
               
    }
    
//    @BeforeClass
//    public static void callApi() {
//        response = 
//                when().
//                get("/flights").
//                then().
//                contentType(ContentType.JSON).
//                extract().response();
//        
//        jsonAsString = response.asString();
//    }
    
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
