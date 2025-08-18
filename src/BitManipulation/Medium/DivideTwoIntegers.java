package BitManipulation.Medium;

//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be
// truncated to 8, and -2.7335 would be truncated to -2.
//Return the quotient after dividing dividend by divisor.
//Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
// [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the
// quotient is strictly less than -231, then return -231.

//Example 1:
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
//Example 2:
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.


public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(7,3));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == divisor){
            return 1;
        }
        boolean sign = true;
        if(divisor > 0 && dividend < 0){
            sign = false;
        }
        if(divisor < 0 && dividend > 0){
            sign = false;
        }
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;
        while(n >= d){
            int count = 0;
            while(n >=  (d << (count + 1))){
                count++;
            }
            ans += (1L << count);
            n -= (d * (1L << count));
        }
        if(ans == (1L<<31) && sign){
            return Integer.MAX_VALUE;
        }
        if(ans == (1L<<31) && !sign){
            return Integer.MIN_VALUE;
        }
        return (sign)? (int)ans : (int)-ans;
    }
}
