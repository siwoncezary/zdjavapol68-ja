package exceptions;

public class CarDemo {
    public static void main(String[] args) throws InvalidFuelLevelException {
        Car car = new Car(30);
        car.refuel(20);
        System.out.println(car.getLevel());
        try {
            car.consume(-20);
        } catch (InvalidFuelLevelException e) {
            System.out.println(e.getMessage() +", invalid value: " + e.getFuelLevel());
            e.printStackTrace();
        }
        //car.consume(-20);
    }
}
