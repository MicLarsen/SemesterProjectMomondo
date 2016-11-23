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
    public static TJWSEmbeddedJaxrsServer server;
    public static Tomcat tomcat;


    public BaseRestTest() {
    }


    @BeforeClass
    public static void setUpClass() throws LifecycleException {
    RestAssured.baseURI = "http://localhost:8084/SemesterProjektMomondo";
    RestAssured.basePath = "/api";
//    tomcat = new Tomcat();
//    tomcat.setPort(8080);
//
//    //actually deploy stuff on your tomcat by defining contexts          
//
//    tomcat.start();
//    tomcat.getServer().await();
    
    
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
