package homework.task12;
import java.util.List;

public class Dish implements Ingredient{
    List<Ingredient> ingredients;
    final String name;

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public double weight() {
        return 0;
    }

    @Override
    public double calories() {
        return 0;
    }
}
