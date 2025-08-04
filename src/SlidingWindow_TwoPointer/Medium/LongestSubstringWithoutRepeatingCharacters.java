package SlidingWindow_TwoPointer.Medium;

//Given a string s, find the length of the longest substring without duplicate characters.
//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hset = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;

        while(right<s.length()){
            while(hset.contains(s.charAt(right))){
                hset.remove(s.charAt(left));
                left++;
            }
            hset.add(s.charAt(right));
            right++;
            maxLength = Math.max(maxLength,right-left);
        }

        return maxLength;
    }
}
