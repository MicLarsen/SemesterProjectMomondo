package RESTAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

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
    public static void setUpClass() throws LifecycleException {
    RestAssured.baseURI = "http://localhost:8081";
    RestAssured.basePath = "";
        }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws LifecycleException {
//   tomcat.stop();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
