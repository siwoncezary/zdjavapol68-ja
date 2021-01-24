package inheritance;

abstract public class Animal {
    String[] foods;
    //metody abstrakcyjne
    public abstract void eat(double energy);
    public abstract void sleep(long time);
    //metoda zdefiniowana
    public boolean canEat(String food){
        for(String item: foods){
            if (item.equals(food)){
                return true;
            }
        }
        return false;
    }

    public void setFoods(String[] foods){
        this.foods = foods;
    }

    public String[] getFoods(){
        return foods;
    }
}
