package alqoritm;
import exception.ArrayIsFullException;
import exception.ElementNotFoundException;
import exception.InvalidIndexException;
import exception.NullElementException;

import java.util.Arrays;


public class IntegerListIml implements IntegerList {
    public Integer[] array;
    private int size;


    public IntegerListIml() {
        array = new Integer[10];
    }

    public IntegerListIml(int size) {
        array = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateElement(item);
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateElement(item);
        validateIndex(index);
        if (index == size) {
            array[index] = item;
            size++;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateElement(item);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateElement(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = array[index];
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }


    @Override
    public boolean contains(Integer item) {
       Integer[] storageCopy= toArray();
       sort(storageCopy);
       return binarySearch(storageCopy,item);

    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = array[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer s = array[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;


    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);

    }

    private void sort(Integer[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] >= temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        private boolean binarySearch(Integer[] arr,Integer item){
            int min = 0;
            int max = arr.length - 1;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (item == arr[mid]) {
                    return true;
                }

                if (item < arr[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return false;
        }
        }





