package POTD;

//Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
//Return the largest lucky integer in the array. If there is no lucky integer return -1.

//Example 1:
//Input: arr = [2,2,3,4]
//Output: 2
//Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

//Example 2:
//Input: arr = [1,2,2,3,3,3]
//Output: 3
//Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

//Example 3:
//Input: arr = [2,2,2,3,3]
//Output: -1
//Explanation: There are no lucky numbers in the array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
//        Map<Integer,Integer> hmap = new HashMap<>();
//        for(int i : arr){
//            hmap.put(i,hmap.getOrDefault(i,0)+1);
//        }
//        int ans = -1;
//        for(int i : hmap.keySet()){
//            if(hmap.get(i)==i){
//                if(i>ans){
//                    ans = i;
//                }
//            }
//        }
//        return ans;


        int[] freq = new int[501];
        for(int i : arr){
            freq[i]++;
        }
        int ans = -1;
        for(int i : freq){
            if(freq[i]==i & i>ans){
                ans = i;
            }
        }
        return ans;
    }
}
