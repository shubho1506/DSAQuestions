package Basics.Recursion;

public class PrintNTimes {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int num){
        if(num==0){
            return;
        }
        System.out.println("shubhodeep");
        print(num-1);
    }
}

