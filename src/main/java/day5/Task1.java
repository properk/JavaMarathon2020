package day5;

public class Task1 {
    public static void setupCar(Car car) {
        car.setYearOfIssue(2009);
        car.setColor("Red");
        car.setModelName("Ferrari 480");
    }

    public static void printData(Car car) {
        System.out.println("Год выпуска: " + car.getYearOfIssue());
        System.out.println("Цвет: " + car.getColor());
        System.out.println("Модель: " + car.getModelName());
    }

    public static void main(String[] args) {
        Car ferrari = new Car();
        setupCar(ferrari);
        printData(ferrari);
    }
}
