package exceptions;

public class Car {
    final double capacity;
    double level;

    public Car(double capacity) {
        this.capacity = capacity;
    }

    public void refuel(double fuel){
        if (0 > fuel){
            throw new IllegalArgumentException("Ujemna wartość paliwa!!!");
        }
        if (fuel + level > capacity){
            throw new IllegalArgumentException("Za dużo paliwa chesz dolać " + (capacity - fuel - level));
        }
        level += fuel;
    }

    /**
     * metoda zgłasza własne wyjątki
     * @param fuel poziom zużytego paliwa
     */
    public  void consume(double fuel) throws InvalidFuelLevelException{
        if (0 > fuel) {
            throw new InvalidFuelLevelException(fuel, "Ujemny poziom paliwa, musi być dodatni!!!");
        }
        if (fuel > level){
            throw new InvalidFuelLevelException(fuel, "Nie ma tyle paliwa w baku!");
        }
        level -= fuel;
    }

    public double getLevel() {
        return level;
    }
}
