package Basics.Recursion;

import java.util.ArrayList;

public class LessThanOrEqualFactorial {
    public static void main(String[] args) {
        System.out.println(factorialNumbers(9));
    }

    public static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> arrl =  new ArrayList<>();
        for(long i=1;i<=n;i++){
            if(factorial(i)<=n){
                arrl.add(factorial(i));
            }else{
                return arrl;
            }
        }
        return arrl;
    }


    public static long factorial(long num){
        if(num==1){
            return num;
        }
        return num*factorial(num-1);
    }
}
