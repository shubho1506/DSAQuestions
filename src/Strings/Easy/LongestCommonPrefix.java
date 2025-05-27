package Strings.Easy;

import java.util.Arrays;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix amongst the input strings.
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs==null||strs.length==0)
            return " ";
        Arrays.sort(strs);
        String str1=strs[0];
        String str2=strs[strs.length-1];
        int index=0;
        while(index<str1.length ()&& index<str2.length()){
            if(str1.charAt(index)==str2.charAt(index)){
                index++;
            }
            else{
                break;
            }

        }
        return str1.substring(0,index);
    }
}
