package Basics.Recursion;

public class SumOfSeries {
    public static void main(String[] args) {
        System.out.println(sumOfSeries(sumOfSeries(5)));
    }

    public static int sumOfSeries(int num){
        if(num==1){
            return 1;
        }
        return  num*num*num+sumOfSeries(num-1);
    }
}
