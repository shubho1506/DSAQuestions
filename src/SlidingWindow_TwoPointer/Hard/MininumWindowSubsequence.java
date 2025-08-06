package SlidingWindow_TwoPointer.Hard;

//You are given two strings, s1 and s2. Your task is to find the smallest substring in s1 such that s2 appears as a
// subsequence within that substring.
//The characters of s2 must appear in the same sequence within the substring of s1.
//If there are multiple valid substrings of the same minimum length, return the one that appears first in s1.
//If no such substring exists, return an empty string.
//Note: Both the strings contain only lowercase letters.

//Examples:
//Input: s1 = "geeksforgeeks", s2 = "eksrg"
//Output: "eksforg"
//Explanation: "eksforg" satisfies all required conditions. s2 is its subsequence and it is smallest and leftmost
//among all possible valid substrings of s1.

//Input: s1 = "abcdebdde", s2 = "bde"
//Output: "bcde"
//Explanation:  "bcde" and "bdde" are two substring of s1 where s2 occurs as subsequence but "bcde" occur first
// so we return that.

//Input: s1 = "ad", s2 = "b"
//Output: ""
//Explanation: There is no substring exists.

public class MininumWindowSubsequence {
    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde","bde"));
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int idx = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";

        while(right<s.length() && idx <t.length()){
            if(s.charAt(right)==t.charAt(idx)){
                idx++;
            }
            if(idx==t.length()){
                left = right;
                idx = t.length()-1;
                while (left>=0 && idx>=0){
                    if(s.charAt(left)==t.charAt(idx)){
                        idx--;
                    }
                    left--;
                }
                left++;
                if(minLength>right-left+1){
                    minLength = right-left+1;
                    ans = s.substring(left,left+minLength);
                }
                idx=0;
                right = left+1;
            }
            right++;
        }
        return ans;
    }
}
