package GreedyProblems.Easy;

//Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 }
// and a target value N.
//Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing
// the value of coins required.

//Example 1:
//Input: N = 43
//Output: 20 20 2 1
//Explaination:
//Minimum number of coins and notes needed
//to make 43.

//Example 2:
//Input: N = 1000
//Output: 500 500
//Explaination: minimum possible notes
//is 2 notes of 500.

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        System.out.println(minPartition(43));
    }

    static List<Integer> minPartition(int N) {
        ArrayList<Integer> notes = new ArrayList<>(List.of(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000));
        List<Integer> change = new ArrayList<>();
        for(int i=notes.size()-1;i>=0;i--){
            while (notes.get(i)<=N){
                change.add(notes.get(i));
                N-=notes.get(i);
            }
        }
        return change;
    }
}
