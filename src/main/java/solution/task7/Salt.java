package solution.task7;

public class Salt implements Ingredient{
    private final double weight;

    public Salt(double weight) {
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return 0;
    }
}
