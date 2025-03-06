package Basics.Maths;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x >= 0){
            int num = x;
            int sum = 0;
            while(num>0){
                int a = num%10;
                sum = sum*10 + a;
                num = num/10;
            }
            if(sum==x){
                return true;
            }
            return false;
        }
        return false;
    }
}
