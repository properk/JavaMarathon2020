package day5;


public class Task2 {
    public static void printData(Motorbike motorbike){
        System.out.println("Год выпуска: " + motorbike.getYearOfIssue());
        System.out.println("Цвет: " + motorbike.getColor());
        System.out.println("Модель: " + motorbike.getModelName());
    }

    public static void main(String[] args) {
        Motorbike bmw = new Motorbike(1948,"Black","BMW R 24");
        printData(bmw);
    }
}
