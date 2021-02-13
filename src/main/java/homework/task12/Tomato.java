package homework.task12;

public class Tomato implements Ingredient{
    private static final double CALORIES_PER_GRAM = 0.5;
    final String name;
    final double weight;
    final double calories;

    public Tomato(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
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
