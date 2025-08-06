package SlidingWindow_TwoPointer.Hard;

//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
// every character in t (including duplicates) is included in the window. If there is no such substring,
// return the empty string "".
//The testcases will be generated such that the answer is unique.

//Example 1:
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

//Example 2:
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.

//Example 3:
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int sIndex = -1;
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }

        while(right<s.length()){
            if(hmap.containsKey(s.charAt(right))) {
                hmap.put(s.charAt(right), hmap.get(s.charAt(right)) - 1);
                if(hmap.get(s.charAt(right)) >= 0) {
                    count++;
                }
            }
            while (count==t.length()){
                if((right-left+1)<minLength){
                    minLength = right-left+1;
                    sIndex = left;
                }
                if(hmap.containsKey(s.charAt(left))){
                    hmap.put(s.charAt(left),hmap.get(s.charAt(left))+1);
                    if(hmap.get(s.charAt(left))>0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }

        return sIndex==-1?"":s.substring(sIndex,sIndex+minLength);
    }
}
