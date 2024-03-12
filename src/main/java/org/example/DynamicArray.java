package org.example;

import java.util.Arrays;

public class DynamicArray {

        private int[] array;
        private int size;

        public DynamicArray() {
            array = new int[10];
            size = 0;
        }


        public void sort() {
            sort(0, size - 1);
        }

        private void sort(int low, int high) {
            if (low < high) {
                int pivot = partition(array, low, high);

                sort(low, pivot - 1);
                sort(pivot + 1, high);
            }
        }
    public void add(int value) {
        if (size == array.length) {
            grow();
        }
        array[size++] = value;
    }
    private void grow() {
        int[] newArray = new int[(int) (array.length * 1.5)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
        private int partition(int[] array, int low, int high) {
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

        public int[] getArray() {
            Arrays arrays;
            return Arrays.copyOf(array, size);
        }

}

