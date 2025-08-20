package BitManipulation.Easy;

//Given an integer n, print all the divisors of N in the ascending order.
//
//Examples:
//
//Input : n = 20
//Output: 1 2 4 5 10 20
//Explanation: 20 is completely divisible by 1, 2, 4, 5, 10 and 20.
//Input: n = 21191
//Output: 1 21191
//Explanation: As 21191 is a prime number, it has only 2 factors(1 and the number itself).

import java.util.ArrayList;
import java.util.Collections;

public class AllDivisorsOfNumber {
    public static void main(String[] args) {
        print_divisors(20);
    }

    public static void print_divisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(n/i==i){
                    System.out.print(i+" ");
                }
                else{
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }
        for(int j=list.size()-1;j>=0;j--){
            System.out.print(list.get(j)+" ");
        }
    }

}
