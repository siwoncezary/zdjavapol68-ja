package solution.task4;

public class Triangle extends Shape{
    public Triangle(Point p1, Point p2, Point p3) {
        super(new Point[]{p1,p2,p3});
    }

    @Override
    double area() {
        return Math.abs((points[1].x - points[0].x)*(points[2].y-points[0].y)-(points[2].x - points[0].x)*(points[1].y-points[2].y)*0.5);
    }
}
