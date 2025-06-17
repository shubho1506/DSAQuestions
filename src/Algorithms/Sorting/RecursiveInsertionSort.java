package Algorithms.Sorting;

public class RecursiveInsertionSort {
    public static void insertionSort(int[] arr, int n) {
        if (n <= 1) return;
        insertionSort(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 5, 6};
        insertionSort(arr, arr.length);
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
