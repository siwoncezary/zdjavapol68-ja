package homework.task3;

/**
 * Są trzy klasy: CallPhone, Laptop, SmartWatch
 * Spróbuj znaleźć pola i metody, które są wspólne dla wszystkich klas
 * i na tej podstawie utwórz klasę abstrakcyjną z metodami abstrakcyjnymi i zdefiniowanymi.
 * Zmień definicje danych trzech klas, aby dziedziczyły po utworzonej klasie,
 * (musisz zmienić listę pól i przedefiniować/dodać/usunąc odpowiednie metody, aby
 * spełnione zostały warunki dziedziczenia.
 */
public class Task03 {
    public static void main(String[] args) {
        /**
         * Po wykonaniu zadania zmień typ referencji na zdefiniowaną klasę abstrakcyjną w poniższych trzeh wierszach
         */
        CellPhone superZi = new CellPhone(4000, "Szamsuk", "1678876", 12_000_000);
        Laptop iDaisy = new Laptop(8000, "XYZ-100 RW", 120, "Daisy Co");
        SmartWatch handyWatch = new SmartWatch("Quququ", 1000, "black");
        /**
         * Jeśli po zmianie program wyświetli dokładnie takie same komunikaty, to znaczy, że zadanie zostało wykonane poprawnie
         */
        System.out.println(superZi.getProducer());
        System.out.println(iDaisy.getProducer());
        System.out.println(handyWatch.getProducer());
        System.out.println(superZi.sendSMS("Hello"));
        System.out.println(handyWatch.sendSMS("Hello"));
        System.out.println(iDaisy.sendSMS("Hello"));
        handyWatch.setWiFi(true);
        System.out.println(handyWatch.sendSMS("Hello"));
        superZi.setWiFi(true);
        superZi = new CellPhone(3000, "Czułałej", null, 16_000_000);
        System.out.println(superZi.sendSMS("Hello again"));
    }
}
