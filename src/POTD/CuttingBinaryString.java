package POTD;

//You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this string
//into the minimum number of non-empty substrings such that:
//Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
//No substring should have leading zeros.
//Return the minimum number of such pieces the string can be divided into.
//Note: If it is not possible to split the string in this way, return -1.

//Examples:
//Input: s = "101101101"
//Output: 3
//Explanation: The string can be split into three substrings: "101", "101", and "101", each of which
// is a power of 5 with no leading zeros.

//Input: s = "1111101"
//Output: 1
//Explanation: The string can be split into one binary string "1111101" which is 125 in decimal and a power of 5
// with no leading zeros.

//Input: s = "00000"
//Output: -1
//Explanation: There is no substring that can be split into power of 5.

import java.util.Arrays;

public class CuttingBinaryString {
    public static void main(String[] args) {
        System.out.println(cuts("1111101"));
    }

    public static int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int res = helper(s, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int helper(String s, int index, int[] dp) {
        if (index == s.length()){
            return 0;
        }
        if (dp[index] != -1){
            return dp[index];
        }

        if (s.charAt(index) == '0'){
            return Integer.MAX_VALUE;
        }

        int minCuts = Integer.MAX_VALUE;
        for (int end = index + 1; end <= s.length(); end++) {

            String sub = s.substring(index, end);
            if (isPowerOfFive(sub)) {
                int next = helper(s, end, dp);
                if (next != Integer.MAX_VALUE) {
                    minCuts = Math.min(minCuts, 1 + next);
                }
            }
        }
        return dp[index] = minCuts;
    }

    private static boolean isPowerOfFive(String binary) {
        long val = Long.parseLong(binary, 2);
        if (val == 0) return false;
        while (val % 5 == 0) val /= 5;
        return val == 1;
    }
}
