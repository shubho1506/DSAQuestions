package POTD;

//You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
//
//Note: Positive number starts from 1. The array can have negative integers too.
//
//Examples:
//
//Input: arr[] = [2, -3, 4, 1, 1, 7]
//Output: 3
//Explanation: Smallest positive missing number is 3.
//Input: arr[] = [5, 3, 2, 5, 1]
//Output: 4
//Explanation: Smallest positive missing number is 4.
//Input: arr[] = [-8, 0, -1, -4, -3]
//Output: 1
//Explanation: Smallest positive missing number is 1.

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class SmallestMissingValue {
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        int min = 1;
        Arrays.sort(arr);

        for(int num : arr){
            if(num<min){
                continue;
            }
            if(num==min){
                min++;
            }else if(num>min){
                return min;
            }
        }

        return min;
    }
}
