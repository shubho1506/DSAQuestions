package Strings.Hard;

//Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
//A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough
// times produces a string that starts with s.
//Examples:

//Input: s = "aaaaaa"
//Output: 5
//Explanation: Repeating the proper prefix "aaaaa" forms "aaaaaaaaaa...", which contains "aaaaa" as a prefix.
// No longer proper prefix satisfies this.

//Input: s = "abcab"
//Output: 3
//Explanation: Repeating the proper prefix "abc" forms "abcabc., which contains "abcab" as a prefix. No longer proper
// prefix satisfies this.

//Input: s = "ababd"
//Output: -1
//Explanation: No proper prefix satisfying the given condition.

public class LongestPeriodicProperPrefix {
    public static void main(String[] args) {
        System.out.println(getLongestPrefix("pqrstupqrstupqrs"));
    }

    static int getLongestPrefix(String s) {
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

        if (count>0){
            int length = s.length()-1;
            while (true){
                String str = s.substring(0,length)+s.substring(0,length);
                if(str.startsWith(s)){
                    return length;
                }
                length--;
            }
        }
        return -1;
    }
}
