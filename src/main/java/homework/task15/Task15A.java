package homework.task15;

import java.util.Scanner;

/**
 * Napisz program, który co 5 sekund wyświetla komunikat "Hello" do czasu naciśnięcia klawisza Q przez użytkownika
 */
public class Task15A {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Hello");
                } catch (InterruptedException e) {
                    current.interrupt();
                }
            }
            System.out.println("End of thread.");
        });
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().equals("Q")) {
            Thread.sleep(100);
        }
        thread.interrupt();
    }
}
