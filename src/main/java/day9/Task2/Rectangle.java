package day9.Task2;

public class Rectangle  extends Figure{
    private double height;
    private double weight;

    public Rectangle(double height, double weight, String color) {
        super(color);
        this.height = height;
        this.weight = weight;
    }

    @Override
    public double area() {
        double s =  height * weight;
        return s;
    }

    @Override
    public double perimeter() {
        double p = height + height + weight + weight;
        return p;
    }
}
