package Strings.Medium;

//The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//For example, the beauty of "abaacc" is 3 - 1 = 2.
//Given a string s, return the sum of beauty of all of its substrings.

//Example 1:
//Input: s = "aabcb"
//Output: 5
//Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

//Example 2:
//Input: s = "aabcbaa"
//Output: 17

public class SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySum(s));
    }

    public static int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int [] freq=new int [26];
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]>0){
                        min=Math.min(min,freq[k]);
                        max=Math.max(max,freq[k]);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}
