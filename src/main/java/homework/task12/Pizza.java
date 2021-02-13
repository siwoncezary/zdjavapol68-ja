package homework.task12;

public class Pizza extends Dish implements Ingredient{
    public Pizza(String name) {
        super(name);
    }

    public boolean addCake(Cake cake){
        //dodaj skłądnik tylko raz
        return false;
    }
    //dodaj metody dodające pozostałe składniki
    public boolean isReady(){
        //zwróć true jeśli są wszystkie składniki
        return false;
    }
}
