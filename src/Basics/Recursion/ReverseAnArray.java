package Basics.Recursion;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {9,5,7,2,8};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int arr[]) {
        reverse(arr,0,arr.length-1);
    }

    public static void reverse(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
        reverse(arr,si+1,ei-1);
    }
}
