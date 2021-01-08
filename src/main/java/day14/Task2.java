package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static List<String> parseFileToStringList(File file) {
        List<String> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //Если возраст человека отрицальный (разбиваю строку на массив с двумя элементами: имя и возраст, и проверяю возраст)
                if (Integer.parseInt(line.split(" ")[1]) < 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Некорректный входной файл");
                        return null;
                    }
                }
                //Добавляем запись в лист
                people.add(line);

            }

            //Вывод списка
            System.out.println(people.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        return people;
    }

    public static void main(String[] args) {
        String separator = File.separator;
        String path = separator + "Projects" + separator + "JavaMarathon2020" + separator + "JavaMarathon2020" + separator + "src" + separator + "main" + separator + "java" + separator + "day14" + separator + "people.txt";
        File file = new File(path);
        parseFileToStringList(file);
    }
}
