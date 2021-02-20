package homework.task15;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * CZESC 1
 * Zdefiniowana jest klasa RequestProducer, która symuluje generowanie żadań w postaci łańcuchów.
 * Żadania są umieszczane w kolejce, przekazywanej w konstruktorze.
 * Twoim zadaniem jest napisanie klasy RequestConsumer, która implementuje interfejs Runnable
 * i odbiera z tej samej kolejki żądania. Przetwarzanie żądań polega na sparsowania żądania na liczbę dziesiętną,
 * gdyż każde żądanie jest łańcuchem  liczbą w kodzie szestnastkowym. Wyświetl wartość żadania i otrzymaną liczbę np.
 * request A1BC2 = 662 466
 * Definiując klasę można inspirować się klasą RequestProducer (konstruktor, metoda run())
 * CZESC 2
 * Uzupełnij metodę main, w której utwórz kilka obiektów konsumenta (każdy konsumenet powienien mieć time znacznie większy od czasu producenta),
 * uruchom je w egzekutorze, oraz uzupełnij kod w obsłudze poleceń programu, aby zatrzymywać i uruchamiać wszystkie wątki
 */
class RequestProducer implements Runnable{
    private static final char[] CODES = {'A', 'B', 'C', '1', '3', '5'};
    private Random random = new Random();
    final private  int maxTime;
    final private BlockingQueue<String> requests;

    RequestProducer(int time, BlockingQueue<String> requests) {
        this.maxTime = time;
        this.requests = requests;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                String request = generateRequest();
                System.out.println("Sending request " + request);
                requests.put(request);
                Thread.sleep(random.nextInt(maxTime));
            } catch (InterruptedException e) {
                System.out.println("PRODUCER STOPPED");
                Thread.currentThread().interrupt();
            }
        }
    }

    private String generateRequest(){
        String str = "";
        for(int i = 0; i < 5; i++){
            str += CODES[random.nextInt(5)];
        }
        return str;
    }
}


public class Task15C {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        RequestProducer producer = new RequestProducer(1000, queue);
       //List<RequestConsumer> consumers = Arrays.asList(new RequestConsumer(3000, queue), ..);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer);
        //uruchom wszystkie wątki konsumetów z kolekcji consumers
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            switch (command){
                case "S":
                    System.out.println("STOPPING");
                    service.shutdownNow();
                    break;
                case "R":
                    System.out.println("RUNNING");
                    service = Executors.newCachedThreadPool();
                    service.execute(producer);
                    //ponownie uruchom wszystkei wątki konsumentów z kolekcji consumers
                    break;
                case "Q":
                return;
            }
        }
    }
}
