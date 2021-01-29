package homework.task4;

import java.util.Arrays;

abstract public class Shape {
    final Point[] points;

    protected Shape(Point[] points) {
        this.points = points;
    }

    public  Point[] getPoints(){
        return points;
    }

    abstract double area();

    @Override
    public String toString() {
        return "Shape{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
