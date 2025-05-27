package Strings.Basics;

//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//A shift on s consists of moving the leftmost character of s to the rightmost position.
//For example, if s = "abcde", then it will be "bcdea" after one shift.

//Example 1:
//Input: s = "abcde", goal = "cdeab"
//Output: true

//Example 2:
//Input: s = "abcde", goal = "abced"
//Output: false

public class RotateString {
    public static void main(String[] args) {
        String str = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(str,goal));
    }

    public static boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length()-1;i++){
            if((s.substring(i+1,s.length()) + s.substring(0,i+1)).equals(goal)){
                return true;
            }
        }
        return false;
    }

    public static boolean rotateString2(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        return (s+s).contains(goal);
    }
}
