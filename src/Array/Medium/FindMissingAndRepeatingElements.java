package Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;

//Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and
//one number b occurs twice in the array. Find numbers a and b.
//Note: The test cases are generated such that there always exists one missing and
//one repeating number within the range [1,n].

//Examples:

//Input: arr[] = [2, 2]
//Output: [2, 1]
//Explanation: Repeating number is 2 and smallest positive missing number is 1.

//Input: arr[] = [1, 3, 3]
//Output: [3, 2]
//Explanation: Repeating number is 3 and smallest positive missing number is 2.

//Input: arr[] = [4, 3, 6, 2, 1, 1]
//Output: [1, 5]
//Explanation: Repeating number is 1 and the missing number is 5.

public class FindMissingAndRepeatingElements {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }

    public static ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int[] count = new int[n + 1];
        ArrayList<Integer> al = new ArrayList<>();

        for (int num : arr) {
            count[num]++;
        }

        int miss = -1, rep = -1;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                miss = i;
            } else if (count[i] == 2) {
                rep = i;
            }
        }

        al.add(rep);
        al.add(miss);
        return al;
    }
}
