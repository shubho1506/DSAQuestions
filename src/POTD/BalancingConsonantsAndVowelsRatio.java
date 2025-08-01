package POTD;

//You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets.
// You need to find the number of balanced strings in arr[] which can be formed by concatenating one or more contiguous
// strings of arr[].
//A balanced string contains the equal number of vowels and consonants.

//Examples:
//Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
//Output: 4
//Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with equal consonants and vowels.

//Input: arr[] = ["ab", "be"]
//Output: 3
//Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with equal consonants and vowels.

//Input: arr[] = ["tz", "gfg", "ae"]
//Output: 0
//Explanation: There is no such balanced substring present in arr[] with equal consonants and vowels.

import java.util.HashMap;

public class BalancingConsonantsAndVowelsRatio {
    public static void main(String[] args) {
        String[] arr = {"aeio", "aa", "bc", "ot", "cdbd"};
        System.out.println(countBalanced(arr));
    }

    public static int countBalanced(String[] arr) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int sum = 0;
        int ans = 0;
        for(String i : arr){
            sum += countDiff(i);
            if(hmap.containsKey(sum)){
                ans += hmap.get(sum);
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    private static int countDiff(String str){
        int vowels = 0;
        int consonants = 0;
        for(char ch : str.toCharArray()){
            if (isVowel(ch)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels-consonants;
    }

    private static boolean isVowel(char ch){
        return "aeiou".indexOf(ch)>=0;
    }
}
