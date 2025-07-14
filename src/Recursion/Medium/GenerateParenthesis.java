package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//Example 1:
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]

//Example 2:
//Input: n = 1
//Output: ["()"]

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genHelper(0,0,"",n,ans);
        return ans;
    }

    private static void genHelper(int open,int close,String str,int n,List<String> ans){
        if(open==close && open+close==n*2){
            ans.add(str);
        }
        if(open<n){
            genHelper(open+1,close,str+"(",n,ans);
        }
        if(close<open){
            genHelper(open,close+1,str+")",n,ans);
        }
    }
}
