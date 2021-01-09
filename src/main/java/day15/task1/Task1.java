package day15.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void csvToTxt(File file1, File file2) throws FileNotFoundException {
        //Считываем из файла shoes.csv
        Scanner scanner = new Scanner(file1);
        PrintWriter pw = new PrintWriter(file2);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (Integer.parseInt(line.split(";")[2]) == 0) {
                //Пишем в в файл missing_shoes.txt
                pw.println(line);
            }
        }

        //Закрываем потоки
        scanner.close();
        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Сепаратор
        String separator = File.separator;

        //Путь к файлу csv
        String pathCsv = separator + "Projects" + separator + "JavaMarathon2020" + separator + "JavaMarathon2020" + separator + "src" + separator + "main" + separator + "resources" + separator + "shoes.csv";
        File fileCsv = new File(pathCsv);

        //Путь к файлу txt
        String pathTxt = separator + "Projects" + separator + "JavaMarathon2020" + separator + "JavaMarathon2020" + separator + "src" + separator + "main" + separator + "resources" + separator + "missing_shoes.txt";
        File fileTxt = new File(pathTxt);

        csvToTxt(fileCsv, fileTxt);
    }
}
