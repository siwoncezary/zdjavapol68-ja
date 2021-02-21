package concurrency;

public class MessageRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new MessageRunnable());
        Thread thread1 = new Thread(new MessageRunnable(100));
        thread0.start();         // wywołanie asynchroniczne
        while(!thread0.isAlive()){  //ta pętla powoduje czekanie, aż wątek się uruchomi
        }
        thread1.start();        // wywwołanie asynchroniczne
        Thread.sleep(5000);// wywołanie synchroniczne
        thread0.interrupt();
        thread1.interrupt();
    }
}
