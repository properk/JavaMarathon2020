package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task2 {
    public static void printResult(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double sum = 0;

        String[] numbers = scanner.nextLine().split(" ");

        for (int i = 0; i < numbers.length; i++) {
            sum += Double.parseDouble(numbers[i]);
        }
        System.out.println((int) sum);
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Сепаратор
        String separator = File.separator;

        //Путь к файлу file1.txt
        String path = separator + "Projects"
                + separator + "JavaMarathon2020"
                + separator + "JavaMarathon2020"
                + separator + "src"
                + separator + "main"
                + separator + "java"
                + separator + "day16"
                + separator + "file1.txt";

        //Создаем файл file1.txt
        File file1 = new File(path);

        //Поток для записи в файл file1.txt
        PrintWriter pw = new PrintWriter(file1);

        //Генерация и запись чисел
        for (int i = 0; i < 1000; i++) {
            pw.print((int) (Math.random() * 101) + " ");
        }

        //Закрытие потока для записи
        pw.close();

        //Путь к файлу file2.txt
        path = separator + "Projects"
                + separator + "JavaMarathon2020"
                + separator + "JavaMarathon2020"
                + separator + "src"
                + separator + "main"
                + separator + "java"
                + separator + "day16"
                + separator + "file2.txt";

        //Создаем файл file2.txt
        File file2 = new File(path);

        //Поток для записи в файл file2.txt
        PrintWriter pw2 = new PrintWriter(file2);

        //Сканнер для file1.txt
        Scanner scanner = new Scanner(file1);

        //Объявляем переменные
        double sum = 0;
        double average = 0;

        //Считываем все числа из file1.txt в массив
        String[] numbers = scanner.nextLine().split(" ");

        for (int i = 0; i < numbers.length; i = i + 20) {
            //Считаем сумму 20 чисел
            for (int j = i; j < i + 20; j++) {
                sum += Double.parseDouble(numbers[j]);
            }
            //Считаем среднее арифметическое
            average = sum / 20;
            //Пишем данные в файл file2.txt
            pw2.print(average + " ");
            //Обнуляем переменные
            average = sum = 0;
        }

        //Закрываем поток для записи
        pw2.close();

        //Считаем сумму вещественных чисел из file2.txt и выводим на консоль
        printResult(file2);
    }
}
