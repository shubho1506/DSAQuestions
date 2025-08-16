package POTD;

//Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of
//them in order, it results in the largest possible number. Since the result may be very large, return it as a string.
//Examples:
//Input: arr[] = [3, 30, 34, 5, 9]
//Output: 9534330
//Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement [9, 5, 34, 3, 30] gives the largest value.

//Input: arr[] = [54, 546, 548, 60]
//Output: 6054854654
//Explanation: Given numbers are [54, 546, 548, 60], the arrangement [60, 548, 546, 54] gives the largest value.

//Input: arr[] = [3, 4, 6, 5, 9]
//Output: 96543
//Explanation: Given numbers are [3, 4, 6, 5, 9], the arrangement [9, 6, 5, 4, 3] gives the largest value.

import java.util.Arrays;

public class FormTheLargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(findLargest(arr));
    }

    public static String findLargest(int[] arr) {
        String[] strA = new String[arr.length];
        int i = 0;
        for(int num : arr){
            strA[i++] = Integer.toString(num);
        }
        Arrays.sort(strA,(a, b)->(b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String str : strA){
            sb.append(str);
        }
        return sb.charAt(0)=='0'?"0":sb.toString();
    }
}
