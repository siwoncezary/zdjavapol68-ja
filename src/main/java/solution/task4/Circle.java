package solution.task4;

public class Circle extends Shape{

    private final double radius;

    public Circle(Point p, double radius) {
        super(new Point[]{p});
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
