package solution.task5;

public class Task05 {
    public static void main(String[] args) {
        GasCar car = new GasCar(50);
        System.out.println("Próbujemy zatankować - 5, w baku jest " + car.getFuelLevel() + " a funkcja zwraca: " + car.refuel(-5));
        System.out.println("Próbujemy zatankować 15, w baku jest " + car.getFuelLevel() + " a funkcja zwraca: " + car.refuel(15));
        System.out.println("Próbujemy zatankować 55, w baku jest " + car.getFuelLevel() + " a funkcja zwraca: " + car.refuel(55));
        System.out.println("Próbujemy zatankować 5, w baku jest " + car.getFuelLevel() + " a funkcja zwraca: " + car.refuel(5));
        BrokenGasCar brokenGasCar = new BrokenGasCar(50);
        System.out.println("Auto z zepsutym systemem tankowania");
        System.out.println("Próbujemy zatankować - 5, w baku jest " + brokenGasCar.getFuelLevel() + " a funkcja zwraca: " + brokenGasCar.refuel(-5));
        System.out.println("Próbujemy zatankować 15, w baku jest " + brokenGasCar.getFuelLevel() + " a funkcja zwraca: " + brokenGasCar.refuel(15));
    }
}
