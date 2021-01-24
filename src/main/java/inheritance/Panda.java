package inheritance;

import java.time.LocalDate;

public class Panda extends Bear{
    static final String colorDescription = "Czarne wybarwienie z białymi paskami i głową";

    public Panda(String name, double weight, LocalDate birthDate) {
        /*
            wywołanie konstruktora klasy bazowej
            musi być jako pierwsza instrukcja konstruktora
         */
        super(name, weight, birthDate);
        foods = new String[]{"bambus"};
    }

    @Override
    public String getColor(){
        //wywołanie metody klasy bazowej
        return" czarny z białym" + super.getColor();
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", weight=" + getWeight() +
                ", birthDate=" + birthDate +
                ", colorDescription='" + colorDescription + '\'' +
                '}';
    }
}
