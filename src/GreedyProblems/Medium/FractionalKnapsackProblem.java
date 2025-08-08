package GreedyProblems.Medium;

//Given two arrays, val[] and wt[], representing the values and weights of items, and an integer capacity representing
// the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in
// the knapsack. You are allowed to break items into fractions if necessary.
//Return the maximum value as a double, rounded to 6 decimal places.

//Examples :
//Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
//Output: 240.000000
//Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with
// value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes
// 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack.

//Input: val[] = [60, 100], wt[] = [10, 20], capacity = 50
//Output: 160.000000
//Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00
// from the given capacity of sack.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsackProblem {
    static class Pair{
        int value;
        int weight;
        Pair(int val,int wt){
            this.value = val;
            this.weight = wt;
        }
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;
        System.out.println(fractionalKnapsack(val,wt,capacity));
    }


    static double fractionalKnapsack(int[] values, int[] weights, int W) {
        double maxValue = 0;
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i=0;i<values.length;i++){
            pairs.add(new Pair(values[i],weights[i]));
        }
        Collections.sort(pairs, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).weight<=W){
                maxValue+=pairs.get(i).value;
                W-=pairs.get(i).weight;
            }else{
                maxValue += ((double) W /pairs.get(i).weight)*pairs.get(i).value;
                return maxValue;
            }
        }
        return maxValue;
    }
}
