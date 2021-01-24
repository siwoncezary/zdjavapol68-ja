package inheritance;

import java.time.LocalDate;

public class Bear extends Animal{
    final protected String name;
    final private double weight;
    final LocalDate birthDate;

    public Bear(String name, double weight, LocalDate birthDate) {
        this.name = name;
        this.weight = weight;
        this.birthDate = birthDate;
        foods = new String[]{"ryby", "miodek"};
    }

    public String getColor(){
        return "niewiadomo";
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public void eat(double energy) {
        System.out.println("Jem kalorii " + energy);
    }

    @Override
    public void sleep(long time) {
        System.out.println("Ide spać " + time +" godzin");
    }
}
