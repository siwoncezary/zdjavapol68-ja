package inheritance;

import java.time.LocalDate;

public class BearDemo {
    public static void main(String[] args) {
        Bear misiek = new Bear("Misiek", 150, LocalDate.now());
        Panda panda = new Panda("Panda", 140, LocalDate.now());
        Animal animal = new Panda("AAA", 100, LocalDate.now());
        Bear panda1 = panda;
        Animal[] mojeMiski = new Bear[2];
        mojeMiski[0] = misiek;
        mojeMiski[1] = panda;
        for(Animal m: mojeMiski){
            System.out.println(m);
            if(m instanceof Animal){
                System.out.println("Jest obiekt klasy Animal");
            }
            if(m instanceof Bear){
                System.out.println("Jest obiekt klasy Bear");
            }
            if(m instanceof Panda){
                System.out.println("Jest obiekt klasy Panda");
            }
        }

        System.out.println(panda.canEat("bambus"));
    }
}
