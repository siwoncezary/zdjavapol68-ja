package app;

import inheritance.Bear;
import inheritance.Panda;

import java.time.LocalDate;
class PolarBear extends Bear {

    public PolarBear(String name, double weight, LocalDate birthDate) {
        super(name, weight, birthDate);
    }

    public String getName(){
        
        return name;
    }
}

public class BearApp {
    public static void main(String[] args) {
        Panda panda = new Panda("Panda", 130, LocalDate.now());
    }
}
