package S2S;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Michael
 */
public class AirlineThreadManager implements Runnable{

    private final ScheduledExecutorService airlineScheduler;
    
    public AirlineThreadManager(){
        airlineScheduler = Executors.newScheduledThreadPool(5);
    }
    
    
    public void test() throws InterruptedException, ExecutionException
{   
ExecutorService executor = Executors.newSingleThreadExecutor();
    Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() {
            System.out.println(2);
            return 2;
        }
    };
    Future<Integer> future = executor.submit(callable);
    // future.get() returns 2 or raises an exception if the thread dies, so safer
    executor.shutdown();
}
    
    
    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AirlineThreadManager atm = new AirlineThreadManager();
        atm.test();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
