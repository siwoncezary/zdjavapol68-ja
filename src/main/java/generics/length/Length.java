package generics.length;

abstract public class Length {
    final double length;

    public Length(double length) {
        this.length = length;
    }

    abstract double getInMeter();

    @Override
    public String toString() {
        return "Length{" +
                "length=" + length +
                '}';
    }
}
