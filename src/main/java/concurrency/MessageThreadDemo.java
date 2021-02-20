package concurrency;

import java.util.Scanner;

public class MessageThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MessageThread thread = new MessageThread();
        System.out.println("Uruchamiam wątek!!");
        thread.start();
        System.out.println("Wątek uruchomiony");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            if ("q".equals(command)){
                System.out.println("Chcesz wyjść z programu, musimy zakończyć najpierw wątek");
                thread.interrupt();
            }
            Thread.sleep(100);
            if (thread.isInterrupted()){
                System.out.println("Wątek już się zakończył");
                return;
            }
        }
    }
}
