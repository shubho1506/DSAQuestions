package SlidingWindow_TwoPointer.Hard;

//You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of
// the longest substring that contains exactly k distinct characters.
//Note : If no such substring exists, return -1.

//Examples:
//Input: s = "aabacbebebe", k = 3
//Output: 7
//Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

//Input: s = "aaaa", k = 2
//Output: -1
//Explanation: There's no substring with 2 distinct characters.

//Input: s = "aabaaab", k = 2
//Output: 7
//Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b',
// making it the longest valid substring.

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabaaab",2));
    }

    public static int longestKSubstr(String s, int k) {
        int left =0;
        int right =0;
        int ans = -1;
        int[] charArr = new int[26];
        int unique = 0;
        while(right <s.length()){
            charArr[s.charAt(right)-'a']++;
            if((charArr[s.charAt(right)-'a'])==1){
                unique++;
            }
            while(unique>k){
                charArr[s.charAt(left)-'a']--;
                if(charArr[s.charAt(left)-'a']==0){
                    unique--;
                }
                left++;
            }
            if(unique==k){
                ans = Math.max(ans, right - left+1);
            }
            right++;
        }
        return ans;
    }
}
