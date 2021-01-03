package day9.Task2;

public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c, String color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double pp = perimeter() / 2;
        double s = Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
        return s;
    }

    @Override
    public double perimeter() {
        double p = a + b + c;
        return p;
    }
}
