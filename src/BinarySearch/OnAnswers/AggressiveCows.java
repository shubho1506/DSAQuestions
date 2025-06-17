package BinarySearch.OnAnswers;

//You are given an array with unique elements of stalls[], which denote the position of a stall.
//You are also given an integer k which denotes the number of aggressive cows.
//Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
//Examples :

//Input: stalls[] = [1, 2, 4, 8, 9], k = 3
//Output: 3
//Explanation: The first cow can be placed at stalls[0],
//the second cow can be placed at stalls[2] and
//the third cow can be placed at stalls[3].
//The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.

//Input: stalls[] = [10, 1, 2, 7, 5], k = 3
//Output: 4
//Explanation: The first cow can be placed at stalls[0],
//the second cow can be placed at stalls[1] and
//the third cow can be placed at stalls[4].
//The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.

//Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
//Output: 1
//Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
//The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {10, 1, 2, 7, 5};
        System.out.println(aggressiveCows(stalls,3));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int si = 1;
        int ei = stalls[stalls.length - 1] - stalls[0];

        int ans = -1;

        while (si<=ei){
            int mid = si+(ei-si)/2;

            if(isPossible(stalls,k,mid)){
                ans = mid;
                si=mid+1;
            }else {
                ei=mid-1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] stalls, int k,int maxDist){
        int cows = 1;
        int lastStall = stalls[0];
        for(int stall : stalls){
            if(stall-lastStall>=maxDist){
                cows++;
                lastStall=stall;
            }
            if(cows==k){
                return true;
            }
        }

        return false;
    }
}
