package Basics.Maths;

//Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
// The returned integer should be non-negative as well.
//You must not use any built-in exponent function or operator.
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

//Example 1:
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.

//Example 2:
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

public class sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        int si = 1;
        int ei = x;
        int ans = 1;

        while (si<=ei){
            int mid = si + (ei-si)/2;
            if(mid*mid==x){
                return mid;
            }else if((long)mid*mid>(long) x){
                ei = mid-1;
            }else {
                si = mid+1;
            }
        }
        //when the loop ends the start become greater
        return ei;
    }
}
