package SlidingWindow_TwoPointer.Medium;

//You are given a string s and an integer k. You can choose any character of the string and change it to any
// other uppercase English character. You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

//Example 1:
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.

//Example 2:
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
//There may exist other ways to achieve this answer too.

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int maxLength =  0;
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,hmap.get(s.charAt(right)));
            while ((right-left+1)-maxFreq>k){
                hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                left++;
            }
            maxLength = Math.max(maxLength,(right-left+1));
            right++;
        }
        return maxLength;
    }
}
