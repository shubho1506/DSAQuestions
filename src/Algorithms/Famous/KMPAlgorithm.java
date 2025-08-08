package Algorithms.Famous;

//The KMP algorithm is used for pattern searching in strings.
//It avoids re-checking characters by using a preprocessed LPS (Longest Prefix Suffix) array.
//Time complexity: O(n + m) where n is the length of text and m is the length of pattern.

//Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes
// of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices.
//Note: Return an empty list in case of no occurrences of pattern.
//
//Examples :
//
//Input: txt = "abcab", pat = "ab"
//Output: [0, 3]
//Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3.
//Input: txt = "abesdu", pat = "edu"
//Output: []
//Explanation: There's no substring "edu" present in txt.
//Input: txt = "aabaacaadaabaaba", pat = "aaba"
//Output: [0, 9, 12]
//Explanation:

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        System.out.println(search("aabaacaadaabaaba","aaba"));
    }

    static ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> matches = new ArrayList<>();
        int[] lps = computeLPSArray(pat);
        System.out.println(Arrays.toString(lps));
        int textLength = txt.length();
        int patternLength = pat.length();
        int i = 0; // index for text[]
        int j = 0; // index for pattern[]

        while (i < textLength) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == patternLength) {
                matches.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < textLength && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return matches;
    }

    public static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
