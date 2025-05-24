package Array.Basics;

//Given an array arr[]. The task is to find the largest element and return it.
//
//Examples:
//
//Input: arr[] = [1, 8, 7, 56, 90]
//Output: 90
//Explanation: The largest element of the given array is 90.
//Input: arr[] = [5, 5, 5, 5]
//Output: 5
//Explanation: The largest element of the given array is 5.
//Input: arr[] = [10]
//Output: 10
//Explanation: There is only one element which is the largest.

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        System.out.println(largest(arr));
    }

    public static int largest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for(int i : arr){
            if(i>largest){
                largest = i;
            }
        }
        return largest;
    }
}
