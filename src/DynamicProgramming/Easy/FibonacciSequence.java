package DynamicProgramming.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner sc =   new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibonacciMemo(n,dp));
        System.out.println(fibonacciTab(n));
//        System.out.println(fibonacciN(n));
        fibonacciN(n);
    }


    public static int fibonacciMemo(int n, int[] dp){
        //base case
        if(n==0||n==1){
            return n;
        }
        //check if value is already present in the memo
        if(dp[n]!=-1){
            return dp[n];
        }
        //compute the value/answer and store in the memo
        return dp[n]= fibonacciMemo(n-1,dp)+ fibonacciMemo(n-2,dp);
    }

    public static int fibonacciTab(int n){
        //initialize the dp table
        int[] dp = new int[n+1];
        //initialize the base cases in the table
        dp[0]=0;
        dp[1]=1;
        //run loop to compute the value and store it in the table
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        //return your answer
        return dp[n];
    }

    public static void fibonacciN(int n){
        if(n<=1){
            System.out.println(n);
//            return n;
        }
        int a = 0;
        int b = 1;
//        int c = 0;
        for(int i=2;i<=n;i++){
            int c = a+b;
//            c = a+b;
            a = b;
            b = c;
            System.out.println(c);
        }
//        return c;
    }
}
