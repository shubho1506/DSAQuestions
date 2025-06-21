package Strings.Medium;

//Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings
// (not necessarily distinct) that have exactly k distinct characters.
//Examples :
//Input: s = "abc", k = 2
//Output: 2
//Explanation: Possible substrings are ["ab", "bc"]

//Input: s = "aba", k = 2
//Output: 3
//Explanation: Possible substrings are ["ab", "ba", "aba"]

//Input: s = "aa", k = 1
//Output: 3
//Explanation: Possible substrings are ["a", "a", "aa"]

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(countSubstr("abc",2));
    }

    static int countSubstr(String s, int k) {
        return calcCount(s,k) - calcCount(s,k-1);
    }

    static int calcCount(String s , int k ){

        int i = 0;
        int j = 0 ;
        int n = s.length() ;
        int[] charFreq = new int[26] ;
        int dist_count = 0 ;
        int ans = 0 ;

        while(j<n){
            charFreq[s.charAt(j)-'a']++;
            if(charFreq[s.charAt(j)-'a']==1){
                dist_count++;
            }

            while(dist_count>k){
                charFreq[s.charAt(i)-'a']--;
                if(charFreq[s.charAt(i)-'a']==0){
                    dist_count--;
                }
                i++;
            }
            j++;
            ans+=(j-i+1) ;
        }

        return ans ;
    }
}
