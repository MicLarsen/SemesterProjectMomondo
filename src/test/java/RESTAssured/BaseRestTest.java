package RESTAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Michael
 */
public class BaseRestTest {

    public static Response response;
    public static String jsonAsString;

    public BaseRestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    RestAssured.baseURI = "http://localhost:8084/SemesterProjektMomondo";
    RestAssured.basePath = "/api";
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
