package day4;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void printArrayData(int[] array) {
        printElementsOfArray(array);
        printArrayLength(array);
        printCountOfNumbersMoreThan8(array);
        printCountOfNumbersEqual1(array);
        printCountOfEvenNumbers(array);
        printCountOfOddNumbers(array);
        printSumOfArray(array);
    }

    public static void printElementsOfArray(int[] array) {
        //Вывод элементов массива на экран;
        System.out.println(Arrays.toString(array));
    }

    public static void printArrayLength(int[] array) {
        //Вывод длины массива;
        System.out.println("Длина массива: " + array.length);
    }

    public static void printCountOfNumbersMoreThan8(int[] array) {
        int count = 0;

        //Количество чисел больше 8;
        for (int element : array) {
            if (element > 8) {
                count++;
            }
        }
        System.out.println("Количество чисел больше 8: " + count);
    }

    public static void printCountOfNumbersEqual1(int[] array) {
        int count = 0;
        //Количество чисел равных 1;
        for (int element : array) {
            if (element == 1) {
                count++;
            }
        }
        System.out.println("Количество чисел равных 1: " + count);
    }

    public static void printCountOfEvenNumbers(int[] array) {
        int count = 0;
        //Количество четных чисел;
        for (int element : array) {
            if (element % 2 == 0) {
                count++;
            }
        }
        System.out.println("Количество четных чисел: " + count);
    }

    public static void printCountOfOddNumbers(int[] array) {
        int count = 0;
        //Количество нечетных чисел;
        for (int element : array) {
            if (element % 2 != 0) {
                count++;
            }
        }
        System.out.println("Количество нечетных чисел: " + count);
    }

    public static void printSumOfArray(int[] array) {
        //Сумма всех элементов массива;
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        System.out.println("Сумма всех элементов массива: " + sum);
    }

    public static int[] createAndFillArray(int n) {
        //Создание массива и заполнение случайными целыми значениями от 1 до 10;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) Math.round(Math.random() * 10);
        }
        return array;
    }

    public static int enterNumber() {
        //Ввод числа с клавиатуры;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    public static void main(String[] args) {
        //Ввод числа, заполнение массива и вывод данных о массиве на экран;
        printArrayData(createAndFillArray(enterNumber()));
    }
}
