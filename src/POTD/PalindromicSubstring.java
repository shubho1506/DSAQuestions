package POTD;

//Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string
// must be greater than or equal to 2.
//Note: A substring is palindromic if it reads the same forwards and backwards.

//Examples:
//Input: s = "abaab"
//Output: 3
//Explanation: All palindromic substrings (of length > 1) are: "aba", "aa", "baab".

//Input: s = "aaa"
//Output: 3
//Explanation: All palindromic substrings (of length > 1) are: "aa", "aa", "aaa".

//Input: s = "abbaeae"
//Output: 4
//Explanation: All palindromic substrings (of length > 1) are: "bb", "abba", "aea", "eae".

public class PalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(countPS("abbaeae"));
    }

    public static int countPS(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while (left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
                if (right - left + 1 >= 2) {  // ensure length ≥ 2
                    count++;
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while (left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
                if (right - left + 1 >= 2) {  // ensure length ≥ 2
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }
}
