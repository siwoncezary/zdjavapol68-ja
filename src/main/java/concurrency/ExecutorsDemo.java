package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new MessageRunnable());
        executor.execute(new MessageThread());
        Counter counter = new Counter();
        executor.execute(new CounterThread(counter));
        executor.execute(new MessageThread());
        Thread.sleep(5000);
        executor.shutdown();
    }
}
