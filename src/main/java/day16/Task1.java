package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void printResult(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double sum = 0;

        while (scanner.hasNextLine()) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int i = 0; i < numbers.length; i++) {
                sum += Double.parseDouble(numbers[i]);
            }
            sum /= numbers.length;
        }

        String result = String.format("%.3f", sum);
        System.out.print(sum + " --> " + result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Сепаратор
        String separator = File.separator;

        //Путь к файлу txt
        String path = separator + "Projects"
                + separator + "JavaMarathon2020"
                + separator + "JavaMarathon2020"
                + separator + "src"
                + separator + "main"
                + separator + "java"
                + separator + "day16"
                + separator + "numbers.txt";

        File file = new File(path);
        printResult(file);
    }
}

