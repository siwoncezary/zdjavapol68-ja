package homework.task7;

public class Egg implements Ingredient{
    private static final double CALORIES_PER_GRAM = 1.5;
    private final double weight;
    private final String name;

    public Egg(String name, double weight) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return weight * CALORIES_PER_GRAM;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
