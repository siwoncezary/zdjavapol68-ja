package solution.task4;

import java.util.Arrays;

abstract public class Shape {
    final Point[] points;

    protected Shape(Point[] points) {
        this.points = points;
    }

    public  Point[] getPoints(){
        return new Point[]{points[0], points[1], points[2]};
    }

    abstract double area();

    @Override
    public String toString() {
        return "Shape{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
