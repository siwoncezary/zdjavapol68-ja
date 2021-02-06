package app;

import inheritance.Bear;
import inheritance.Panda;
import java.time.LocalDate;




class PolarBear extends Bear implements Sound{

    public PolarBear(String name, double weight, LocalDate birthDate) {
        super(name, weight, birthDate);
    }

    public String getName(){
        
        return name;
    }

    @Override
    public String getGenerator() {
        return "Bear voice";
    }
}

public class BearApp {
    public static void main(String[] args) {

        PolarBear panda = new PolarBear("Panda", 130, LocalDate.now());
        System.out.println(((Sound) panda).generate());
    }
}
