package solution.task7;

public class Cake implements Ingredient{
    private static final double CALORIES_PER_GRAM = 7;
    private final double weight;
    private final String name;
    private final int size;

    public Cake(double weight, String name, int size) {
        this.weight = weight;
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
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
