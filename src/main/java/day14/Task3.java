package day14;

import day14.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static List<Person> parseFileToObjList(File file) {
        List<Person> persons = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
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

                persons.add(new Person(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        return persons;
    }

    public static void main(String[] args) {
        String separator = File.separator;
        String path = separator + "Projects" + separator + "JavaMarathon2020" + separator + "JavaMarathon2020" + separator + "src" + separator + "main" + separator + "java" + separator + "day14" + separator + "people.txt";
        File file = new File(path);
        List<Person> persons = parseFileToObjList(file);

        System.out.println(persons);
    }
}
