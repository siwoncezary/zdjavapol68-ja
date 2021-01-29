package homework.task4;

public class Square extends Shape{

    private final int side;
    public Square(Point p, int side) {
        super(new Point[]{
                new Point(p.x, p.y),
                new Point(p.x + side, p.y),
                new Point(p.x + side, p.y + side),
                new Point(p.x, p.y + side)
        });
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}
