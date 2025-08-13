package POTD;

//You are given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop.
// You are also given an integer k. A troop is considered "lucky" if its number of soldiers is a multiple of k.
// Find the minimum total number of soldiers to add across all troops so that at least ⌈n / 2⌉ troops become lucky.
//Examples:
//Input: arr = [5, 6, 3, 2, 1], k = 2
//Output: 1
//Explanation: By adding 1 soldier for the troop with 1 soldier, we get [5, 6, 3, 2, 2].
//Now 3 out of 5 troops (6, 2, and 2) are multiples of 2 that satisfy the requirement.
//Input: arr = [3, 5, 6, 7, 9, 10], k = 4
//Output: 4
//Explanation: We need at least 3 lucky troops since ⌈6 / 2⌉ = 3. Currently, no troop is divisible by 4.
//Add 1 soldier for troop 3 → 4,
//Add 2 for troop 6 → 8,
//Add 1 for troop 7 → 8.
//New array: [4, 5, 8, 8, 9, 10] with 3 lucky troops (4, 8, 8).
//Total soldiers added = 4.

import java.util.Arrays;

public class TywinWarStratergy {
    public static void main(String[] args) {
        int[] arr = {8, 9, 9, 8, 6, 1, 8, 4, 10, 9};
        System.out.println(minSoldiers(arr,10));
    }

    public static int minSoldiers(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if (arr[i] % k == 0) {
                arr[i] = 0;
            } else if (arr[i] < k) {
                arr[i] = k - arr[i];
            } else {
                arr[i] = k - (arr[i] % k);
            }
        }
        Arrays.sort(arr);
        int minValue =0;
        for(int i=0;i<(arr.length+1)/2;i++){
            minValue +=arr[i];
        }
        return minValue;
    }
}
