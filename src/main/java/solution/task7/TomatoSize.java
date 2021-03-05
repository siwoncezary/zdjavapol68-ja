package solution.task7;

public enum TomatoSize {
    SMALL(6), MEDIUM(12), LARGE(18), EXTRA_LARGE(24);

    private double weight;

    TomatoSize(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
