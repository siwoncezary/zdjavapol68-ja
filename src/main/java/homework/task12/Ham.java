package homework.task12;

public class Ham implements Ingredient{
    final String name;
    final double weight;
    final double caloriesPerGram;

    public Ham(String name, double weight, double caloriesPerGram) {
        this.name = name;
        this.weight = weight;
        this.caloriesPerGram = caloriesPerGram;
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
        return weight * caloriesPerGram;
    }
}
