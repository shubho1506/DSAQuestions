package Basics.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfMostFrequentElement {

    //Example 1:
    //Input: array[] = {10,5,10,15,10,5};
    //Output: 10 15
    //Explanation: The frequency of 10 is 3, i.e. the highest and the frequency of 15 is 1
    // i.e. the lowest.
    //Example 2:
    //Input: array[] = {2,2,3,4,4,2};
    //Output: 2 3
    //Explanation: The frequency of 2 is 3, i.e. the highest and the frequency of 3 is 1
    // i.e. the lowest.

    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        int[] arr1 = {2,2,3,4,4,2};

        System.out.println(Arrays.toString(maxFrequency(arr)));
        System.out.println(Arrays.toString(maxFrequency(arr1)));

    }

    public static int[] maxFrequency(int[] nums) {
        int[] count = new int[2]; //index 0  stores maximum frequency value and index1 stores minimum frequency value
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums){
            hmap.put(i, hmap.getOrDefault(i, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : hmap.keySet()){
            if(min > hmap.get(i)){
                count[1] = i;
                min = hmap.get(i);
            }
            if(max < hmap.get(i)){
                count[0] = i;
                max = hmap.get(i);
            }
        }
        return count;
    }
}
