package SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 6, 5, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        System.out.println(Arrays.toString(array));

        return i;
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        return array;
    }
}
