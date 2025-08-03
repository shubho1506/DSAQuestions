package POTD;

//You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2
// representing the cost of fruit in each basket. You want to make both baskets equal.
// To do so, you can use the following operation as many times as you want:
//Chose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
//The cost of the swap is min(basket1[i],basket2[j]).
//Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
//Return the minimum cost to make both the baskets equal or -1 if impossible.

//Example 1:
//Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
//Output: 1
//Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1.
// Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.

//Example 2:
//Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
//Output: -1
//Explanation: It can be shown that it is impossible to make both the baskets equal.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RearrangingFruits {
    public static void main(String[] args) {
        int[] basket1 = {4,2,2,2,3,3,3,3};
        int[] basket2 = {1,4,1,2,5,5,6,6};
        System.out.println(minCost(basket1,basket2));
    }

    public static long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> counts = new HashMap<>();

        for(int i=0;i<basket1.length;i++){
            counts.put(basket1[i],counts.getOrDefault(basket1[i],0)+1);
            counts.put(basket2[i],counts.getOrDefault(basket2[i],0)-1);
        }

        ArrayList<Integer> swaps = new ArrayList<>();
        int minValue =Integer.MAX_VALUE;
        long minCost = 0;

        for(Map.Entry<Integer, Integer> map : counts.entrySet()){
            int num = map.getKey();
            int count = map.getValue();
            if(count%2==1){
                return -1;
            }
            minValue = Math.min(minValue,num);
            for(int i=0;i<Math.abs(count)/2;i++){
                swaps.add(num);
            }
        }

        Collections.sort(swaps);

        for (int i = 0; i < swaps.size() / 2; i++) {
            minCost += Math.min(swaps.get(i), 2 * minValue);
        }

        return minCost;
    }
}
