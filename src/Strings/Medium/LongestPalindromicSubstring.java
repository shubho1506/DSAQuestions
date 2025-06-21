package Strings.Medium;

//Given a string s, return the longest palindromic substring in s.

//Example 1:
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.

//Example 2:
//Input: s = "cbbd"
//Output: "bb"

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        if(s.length()==1){
            return s;
        }

        String max = "";

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if((isPalindrome(s.substring(i,j))) && (s.substring(i,j).length()>max.length())){
                    max = s.substring(i,j);
                }
            }
        }

        return max;
    }

    static boolean isPalindrome(String s){
        int si=0;
        int ei=s.length()-1;

        while(si<ei){
            if(s.charAt(si++) != s.charAt(ei--)){
                return false;
            }
        }

        return true;
    }
}
