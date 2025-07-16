package POTD;

//Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.
//Examples :
//Input: n = 100
//Output: 2
//Explanation: Numbers which have exactly 9 divisors are 36 and 100.
//Input: n = 200
//Output: 3
//Explanation: Numbers which have exactly 9 divisors are 36, 100, 196.

public class NineDivisors {
    public static void main(String[] args) {
        System.out.println(countNumbers(100));
    }

    public static int countNumbers(int n) {
        if(n<36) return 0;
        int i = 6;
        int ans = 0;
        while((i*i)<=n){
            if(count(i)==9){
                ans++;
            }
            i++;
        }
        return ans;
    }

    public static int count(int n){
        int i = 2;
        int ans = 3;
        int num = n*n;
        for(int j=i;j<n;j++){
            if(num%j==0) ans+=2;
            if(ans>9) return ans;
        }
        return ans;
    }
}
