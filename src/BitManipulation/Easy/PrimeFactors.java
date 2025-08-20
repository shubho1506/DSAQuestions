package BitManipulation.Easy;

//Given a number n. Find its unique prime factors in increasing order.
//Examples :
//Input: n = 100
//Output: [2, 5]
//Explanation: Unique prime factors of 100 are 2 and 5.
//Input: n = 60
//Output: [2, 3, 5]
//Explanation: Prime factors of 60 are 2, 2, 3, 5. Unique prime factors are 2, 3 and 5.

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(primeFac(42));
    }

    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                primes.add(i);
                while (n%i==0){
                    n/=i;
                }
            }
        }
        if(n>1){
            primes.add(n);
        }
        return primes;
    }
}
