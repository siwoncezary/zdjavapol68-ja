package homework.task4;

public class Section extends Shape{
    protected Section(Point p1, Point p2) {
        super(new Point[]{
                p1,
                p2
        });
    }

    @Override
    double area() {
        return 0;
    }

    public boolean isVertical(){
        return points[0].y == points[1].y;
    }
}
