package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable task = () ->{
            int localCounter = 10;
            System.out.println("Running thread " + Thread.currentThread().getId());
            while(localCounter-- > 0){
                counter.addAndGet(1);
            }
            System.out.println("Ending thread " + Thread.currentThread().getId());
        };
        service.execute(task);
        service.execute(task);
        service.execute(task);
        service.execute(task);
        service.execute(task);
        Thread.sleep(10);
        System.out.println(counter.get());
    }
}
