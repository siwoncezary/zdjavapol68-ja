package homework.task12;

public class Cake implements Ingredient{
    private static double CALORIES_PER_GRAM = 0.2;
    final String name;
    final double weight;

    public Cake(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return weight * CALORIES_PER_GRAM;
    }
}
