package Strings.Medium;

//Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present
// in the array words[].
//Note: If multiple strings have the same maximum length, return the lexicographically smallest one.

//Examples:
//Input: words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
//Output: pros
//Explanation: "pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present in the array words[].

//Input: words[] = ["ab", "a", "abc", "abd"]
//Output: abc
//Explanation: Both "abc" and "abd" has all the prefixes in words[]. Since, "abc" is lexicographically smaller
//than "abd", so the output is "abc".

import java.util.Arrays;
import java.util.HashSet;

public class FindTheLongestString {
    public static void main(String[] args) {
        String[] words = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println(longestString(words));
    }

    public static String longestString(String[] words) {
        HashSet<String> hset = new HashSet<>();

        for(String str : words){
            hset.add(str);
        }

        Arrays.sort(words,(a,b)->{
            if(a.length() != b.length()){
                return b.length()-a.length();
            }else{
                return a.compareTo(b);
            }
        });

        String ans = "";
        int size = Integer.MIN_VALUE;

        for(String str : words){
            int count = 0;
            for(int i=1;i<str.length();i++){
                if (hset.contains(str.substring(0,i))) {
                    count++;
                }else{
                    break;
                }
            }
            if(count==str.length()-1){
                return str;
            }
        }

        return ans;
    }
}
