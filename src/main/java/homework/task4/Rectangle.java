package homework.task4;

public class Rectangle extends Shape{
    private final int width;
    private final int height;
    public Rectangle(Point p, int width, int height){
        super(new Point[]{
                new Point(p.x, p.y),
                new Point(p.x + width, p.y),
                new Point(p.x + width, p.y + height),
                new Point(p.x, p.y + height)
        });
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    public Rectangle moveTo(Point p){
        return new Rectangle(new Point(p.x, p.y), width, height);
    }
}
