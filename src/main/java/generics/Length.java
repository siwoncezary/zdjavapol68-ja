package generics;

abstract public class Length {
    final double length;

    public Length(double length) {
        this.length = length;
    }

    abstract double getInMeter();
}
