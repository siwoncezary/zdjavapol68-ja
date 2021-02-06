package hermetization;

import java.util.Random;

public class AbstractClassAsInterfaceDemo {
    public static void main(String[] args) {
        Bank bank = new SuperHackerBank();
        Random random = new Random();
        while(true){
            //symulujemy wplaty
            final String feedback = bank.credit(random.nextInt(1000));
            System.out.println(feedback);
            //sprawdzamy czy mamy na koncie odpowiednią kwotę
            if(bank.balance() >= 100_000){
                System.out.println("Możesz kupić samochód");
                break;
            }
        }
        System.out.println("Stan konta: " +bank.balance());
        System.out.println(bank.debit(200_000));
        System.out.println("Stan konta: " + bank.balance());
    }
}
