package concurrency;

public class MessageThread extends Thread{

    @Override
    public void run() {
        while(!this.isInterrupted()){
            System.out.println("Aktualna temperatura: " + 100);
            //tutaj własny kod wykonywany w każdej pętli wątku
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku");
                this.interrupt();
            }
        }
        System.out.println("KONIEC WĄTKU");
    }
}
