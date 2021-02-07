package anonymous;

import interfaces.MyBank;
import interfaces.Printable;
import interfaces.Report;

public class PrintDemo {
    public static void main(String[] args) {
        Printable[] toPrint = new Printable[3];
        toPrint[0] = new Report("Zawartość");
        //tworzenie obiektu klasy anonimowej implementującej interfejs Printable
        toPrint[1] = new Printable() {
            static final int COPIES = 5;
            private void intro(String device){
                System.out.println("Printing using device: " + device);
            }
            @Override
            public String print(String device) {
                intro(device);
                return "Obiekt klasy anonimowej " + COPIES;
            }
        };
        toPrint[2] = new MyBank();
        for(Printable p: toPrint){
            System.out.println(p.print("HP"));
        }
    }
}
