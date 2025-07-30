package POTD;

//Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.
//
//Examples:
//
//Input: arr[] = [10, 2, -2, -20, 10], k = -10
//Output: 3
//Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
//Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33
//Output: 2
//Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
//Input: arr[] = [1, 3, 5], k = 0
//Output: 0
//Explaination: No subarray with 0 sum.

import java.util.HashMap;

public class SubarraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        System.out.println(cntSubarrays(arr,-10));
    }

    public static int cntSubarrays(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int sum=0;
        int count=0;
        map.put(0,1);

        for(int i=0; i<arr.length; i++)
        {
            sum+=arr[i];

            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
