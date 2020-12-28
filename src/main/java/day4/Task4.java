package day4;

public class Task4 {
    public static int[] createAndFillArray(int n) {
        //Создание массива и заполнение случайными целыми значениями от 1 до 10000;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) Math.round(Math.random() * 10000);
        }
        return array;
    }

    public static void findMaxTripleOfNumbersAndTheIndex(int[] array){
        int index = 0;
        int currentSum;
        int maxSum = array[0];

        //Поиск максимальной суммы тройки чисел (выкидываем из цикла 2 последних числа, чтобы не было исключения);
        for (int i = 0; i < array.length - 2; i++) {
            currentSum = array[i] + array[i + 1] + array[i + 2];
            if (maxSum < currentSum) {
                maxSum = currentSum;
                index = i;
            }
        }

        System.out.println(maxSum);
        System.out.println(index);
    }

    public static void main(String[] args) {
        findMaxTripleOfNumbersAndTheIndex(createAndFillArray(100));
    }
}
