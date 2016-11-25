package RESTAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import test.utils.EmbeddedTomcat;

/**
 *
 * @author Michael
 */

public class BaseRestTest {

//    public static EmbeddedTomcat tomcat;

    public BaseRestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ServletException, MalformedURLException, LifecycleException {
//        tomcat = new EmbeddedTomcat();
//        tomcat.start(9999, "/");

    }
@Ignore
    @Test
    public void checkConnection() {
        given().
                when().get().then().statusCode(200);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
//        tomcat.stop();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
