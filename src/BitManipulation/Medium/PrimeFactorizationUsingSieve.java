package BitManipulation.Medium;

//You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.
//Example:
//Input:
//N = 12246
//Output:
//2 3 13 157
//Explanation:
//2*3*13*157 = 12246 = N.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationUsingSieve {
    public static void main(String[] args) {
        sieve();
        System.out.println(findPrimeFactors(12246));
    }

    static int MAX=200000;
    static int[] spf=new int[MAX+1];
    static void sieve() {
        for(int i=1;i<=MAX;i++)spf[i]=i;
        for(int i=2;i*i<MAX;i++){
            if(spf[i]==i){
                for(int j=i*i;j<=MAX;j+=i){
                    if(spf[j]==j)spf[j]=i;
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int n) {
        List<Integer> res=new ArrayList<>();
        while(n>1){
            int prime=spf[n];
            res.add(prime);
            n/=prime;
        }
        return res;
    }
}
