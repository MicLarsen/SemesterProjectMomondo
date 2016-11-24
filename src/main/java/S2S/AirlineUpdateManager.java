package S2S;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Michael
 */
@WebListener
public class AirlineUpdateManager implements ServletContextListener  {

    private final ScheduledExecutorService airlineScheduler;    
    
    public AirlineUpdateManager() {
        airlineScheduler = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

        airlineScheduler.scheduleAtFixedRate(new AirlineInfo(), 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        airlineScheduler.shutdownNow();
    }

}
