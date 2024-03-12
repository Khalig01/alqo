package org.example;
import java.util.Random;
import java.util.Arrays;

public class  Main {

    private static final int ARRAY_SIZE = 100_000;

    public static void main(String[] args) {
        Random random = new Random();
        int[] array1 = new int[ARRAY_SIZE];
        int[] array2 = new int[ARRAY_SIZE];
        int[] array3 = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array1[i] = random.nextInt();
            array2[i] = array1[i];
            array3[i] = array1[i];
        }

        long start = System.currentTimeMillis();
        bubbleSort(array1);
        long bubbleSortTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        insertionSort(array2);
        long insertionSortTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        quickSort(array3);
        long quickSortTime = System.currentTimeMillis() - start;

        System.out.println("Время пузырьковой сортировки: " + bubbleSortTime + " мс");
        System.out.println("Время сортировки вставкой: " + insertionSortTime + " мс");
        System.out.println("Время быстрой сортировки: " + quickSortTime + " мс");

        System.out.println("Самая быстрая сортировка: " + getFastestSort(bubbleSortTime, insertionSortTime, quickSortTime));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentElement;
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static String getFastestSort(long bubbleSortTime, long insertionSortTime, long quickSortTime) {
        if (bubbleSortTime <= insertionSortTime && bubbleSortTime <= quickSortTime) {
            return "Пузырьковая сортировка";
        } else if (insertionSortTime <= bubbleSortTime && insertionSortTime <= quickSortTime) {
            return "Сортировка вставкой";
        } else {
            return "Быстрая сортировка";
        }
    }
}
