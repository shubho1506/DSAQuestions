package Algorithms.NotSoFamous;

import java.util.Arrays;

public class CountFreqInArray {
    public static void main(String[] args) {
        String s = "ahbdhbjkadbhdbkddsb";
        System.out.println(Arrays.toString(freqArray(s)));
    }

    public static int[] freqArray(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}
