package Strings.Hard;

//Given a string s, of lowercase english alphabets, find the length of the longest prefix which is also a suffix.
//Note: Prefix and suffix can be overlapping but they should not be equal to the entire string.
//Examples :
//Input: s = "abab"
//Output: 2
//Explanation: The string "ab" is the longest prefix and suffix.

//Input: s = "aabcdaabc"
//Output: 4
//Explanation: The string "aabc" is the longest prefix and suffix.

//Input: s = "aaaa"
//Output: 3
//Explanation: "aaa" is the longest prefix and suffix.

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        System.out.println(getLPSLength("pqrstupqrstupqrs"));
    }

    static int getLPSLength(String s) {
        int prefix = 0;
        int suffix = 1;
        int count = 0;
        int pos = 1;

        while (prefix<s.length() && suffix<s.length()){
            if(s.charAt(prefix)==s.charAt(suffix)){
                prefix++;
                suffix++;
                count++;
            }else{
                prefix = 0;
                pos++;
                suffix = pos;
                count = 0;
            }
        }
        return count;
    }
}
