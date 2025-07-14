package Recursion.Medium;

//Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.
//A binary string is that string which contains only 0 and 1.
//Example 1:
//Input:
//N = 3
//Output:
//000 , 001 , 010 , 100 , 101
//Explanation:
//None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively.

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(3));
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> arrl = new ArrayList<>();
        genHelper("",n,arrl);
        return arrl;
    }

    private static void genHelper(String ans,int n,List<String> arrl){
        if(ans.length()==n){
            arrl.add(ans);
            return;
        }
        genHelper(ans+"0",n,arrl);
        if(ans.isEmpty()||ans.charAt(ans.length()-1)!='1'){
            genHelper(ans+"1",n,arrl);
        }
    }
}
