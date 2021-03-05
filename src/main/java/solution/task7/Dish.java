package solution.task7;

public class Dish implements Ingredient{
    private final Ingredient[] ingredients;


    public Dish(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public double weight() {
        double weight = 0;
        for(Ingredient in: ingredients){
            weight += in.weight();
        }
        return weight;
    }

    @Override
    public double calories() {
        double calories = 0;
        for(Ingredient in: ingredients){
            calories += in.calories();
        }
        return calories;
    }
}
