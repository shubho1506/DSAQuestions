package Basics.Maths;

public class CheckForPrime {
    public static void main(String[] args) {
        System.out.println(checkPrime(3));
        System.out.println(checkPrimeOptimized(98));
    }

    public static boolean checkPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<num;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static boolean checkPrimeOptimized(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
