package concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int[] prices = new int[10000];
        Random random = new Random();
        for (int i= 0; i < prices.length; i++){
            prices[i] = random.nextInt(10000);
        }
        Callable<Integer> sum = () -> {
            Thread current = Thread.currentThread();
            int s = 0;
            System.out.println("START");
            for(int i: prices){
                if (current.isInterrupted()){
                    return -s;
                }
                s += i;
            }
            return s;
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> integerFuture = service.submit(sum);
        Integer wynik = integerFuture.get(1, TimeUnit.MICROSECONDS);
        System.out.println(wynik);
        service.shutdown();
    }
}
