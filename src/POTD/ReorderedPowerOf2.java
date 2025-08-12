package POTD;

//You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//Return true if and only if we can do this so that the resulting number is a power of two.

//Example 1:
//
//Input: n = 1
//Output: true
//Example 2:
//
//Input: n = 10
//Output: false

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(821));
    }

    public static boolean reorderedPowerOf2(int n) {
        int[] countNum = countDigits(n);
        for(int i=0;i<31;i++){
            int num = 1<<i;
            int[] countPowerNum = countDigits(num);
            if(matches(countNum,countPowerNum)){
                return true;
            }
        }
        return false;
    }

    private static boolean matches(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] countDigits(int num){
        int[] count = new int[10];
        while (num>0){
            count[num%10]++;
            num /= 10;
        }
        return count;
    }
}
