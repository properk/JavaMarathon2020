package day2;

import java.util.Scanner;

public class Task4 {

    public static double func(double x) {
        if (x >= 5) {
            return (x * x - 10) / (x + 7);
        } else if (x > -3 && x < 5) {
            return (x + 3) * (x * x - 2);
        } else return 420;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        scanner.close();

        double y;
        y = func(x);

        System.out.println(y);
    }
}
