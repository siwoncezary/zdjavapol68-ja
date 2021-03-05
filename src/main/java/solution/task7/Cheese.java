package solution.task7;

public class Cheese implements Ingredient{
    private static final double CALORIES_PER_GRAM = 5;
    private final double weight;
    private final String name;

    public Cheese(double weight, String name) {
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
}
