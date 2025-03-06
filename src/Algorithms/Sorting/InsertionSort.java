package Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9,3,2,5,1,7};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // Element to be inserted
            int j = i - 1;
            // Shift elements of sorted portion to create space for key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Place key in the correct position
            arr[j + 1] = key;
        }
        return arr;
    }
}
