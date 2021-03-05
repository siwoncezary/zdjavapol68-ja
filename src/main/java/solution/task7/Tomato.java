package solution.task7;

public class Tomato implements Ingredient{
    private static final double CALORIES_PER_GRAM = 2;
    //przykład jak można wykorzystać enum, który określa rozmiary pomidorów
    private TomatoSize tomatoSize;
    private final String name;
    private final String taste;

    public Tomato(TomatoSize tomatoSize, String name, String taste) {
        this.tomatoSize = tomatoSize;
        this.name = name;
        this.taste = taste;
    }

    public String getName() {
        return name;
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public double weight() {
        return tomatoSize.getWeight();
    }

    @Override
    public double calories() {
        return tomatoSize.getWeight() * CALORIES_PER_GRAM;
    }
}
