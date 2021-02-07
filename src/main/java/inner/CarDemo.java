package inner;

public class CarDemo {
    public static void main(String[] args) {
        Car.Radio radio = new Car.Radio(1200);
        Car fiat = new Car();
        fiat.setRadio(radio);
        System.out.println(fiat);
    }
}
