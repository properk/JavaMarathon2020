package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {

    public static void printSumDigits(File file) {
        try {
            //Создаем сканнер
            Scanner scanner = new Scanner(file);
            //Считываем числа из строки
            String line = scanner.nextLine();
            //Считываем в массив числа, разделенные пробелом
            String[] numbers = line.split(" ");

            //Проверка, что чисел нужное количество
            if (numbers.length != 10) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Некорректный входной файл");
                }
            }

            //Собираем сумму
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }

            //Выводим сумму
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        //Сделал изначально так, думал, что каждое новое число должно с новой строки..
//        int countOfNumbers = 0;
//        try {
//
//            int sum = 0;
//
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                if (scanner.hasNextInt()) {
//                    countOfNumbers++;
//                }
//                int a = Integer.parseInt(scanner.nextLine());
//                sum += a;
//            }
//
//            if (countOfNumbers != 10) {
//                try{
//                    throw new Exception();
//                } catch(Exception e){
//                    System.out.println("Некорректный входной файл");
//                    return;
//                }
//            }
//
//            System.out.println(sum);
//
//            scanner.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден");
//        }

    }

    public static void main(String[] args) {
        String separator = File.separator;
        String path = separator + "Projects" + separator + "JavaMarathon2020" + separator + "JavaMarathon2020" + separator + "src" + separator + "main" + separator + "java" + separator + "day14" + separator + "numbers.txt";
        File file = new File(path);
        printSumDigits(file);
    }
}
