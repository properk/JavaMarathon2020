package day4;

public class Task2 {
    public static int[] createAndFillArray(int n) {
        //Создание массива и заполнение случайными целыми значениями от 1 до 10;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) Math.round(Math.random() * 10000);
        }
        return array;
    }

    public static void getMaxElement(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (max < element) {
                max = element;
            }
        }
        System.out.println("Наибольший элемент массива: " + max);
    }

    public static void getMinElement(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (min > element) {
                min = element;
            }
        }
        System.out.println("Наименьший элемент массива: " + min);
    }

    public static void getCountOfElementsEndOfZero(int[] array) {
        int count = 0;
        for (int element : array) {
            if (element % 10 == 0) {
                count++;
            }
        }
        System.out.println("Количество элементов массива, оканчивающихся на 0: " + count);
    }

    public static void getSumOfElementsEndOfZero(int[] array) {
        int sum = 0;

        for (int element : array) {
            if(element % 10 == 0){
              sum +=element;
            }
        }
        System.out.println("Сумму элементов массива, оканчивающихся на 0: " + sum);
    }

    public static void main(String[] args) {
        int[] array = createAndFillArray(100);
        getMaxElement(array);
        getMinElement(array);
        getCountOfElementsEndOfZero(array);
        getSumOfElementsEndOfZero(array);
    }
}
