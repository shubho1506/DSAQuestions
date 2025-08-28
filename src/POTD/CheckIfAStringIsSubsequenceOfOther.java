package POTD;

//Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
//Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing
//the order of the remaining elements.
//Examples:
//Input: s1 = "AXY", s2 = "YADXCP"
//Output: false
//Explanation: s1 is not a subsequence of s2 as 'Y' appears before 'A'.
//Input: s1 = "gksrek", s2 = "geeksforgeeks"
//Output: true
//Explanation: If we combine the bold character of "geeksforgeeks", it equals to s1. So s1 is a subsequence of s2.

public class CheckIfAStringIsSubsequenceOfOther {
    public static void main(String[] args) {
        System.out.println(isSubSeq("gksrek","geeksforgeeks"));
    }

    public static boolean isSubSeq(String s1, String s2) {
        if(s1.length()<s2.length()){
            return isSubsequence(s2,s1);
        }
        return isSubsequence(s1,s2);
    }

    private static boolean isSubsequence(String str1,String str2){
        int idx1 = 0;
        int idx2 = 0;
        while (idx1<str1.length() && idx2<str2.length()){
            if(str1.charAt(idx1)==str2.charAt(idx2)){
                idx2++;
                if(idx2==str2.length()){
                    return true;
                }
            }
            idx1++;
        }
        return false;
    }
}
