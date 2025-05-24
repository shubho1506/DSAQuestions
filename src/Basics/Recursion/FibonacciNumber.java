package Basics.Recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(3));
    }

    public static int fibonacciNumber(int num) {
        if(num==1){
            return num;
        }
        return num + fibonacciNumber(num-1);
    }
}
