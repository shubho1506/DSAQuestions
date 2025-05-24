package Basics.Maths;
//Given a positive integer n, The task is to find the value of Σi F(i)
// where i is from 1 to n and function F(i) is defined as the sum of all divisors of i.
//
//Examples:
//
//Input: n = 4
//Output: 15
//Explanation:
//F(1) = 1
//F(2) = 1 + 2 = 3
//F(3) = 1 + 3 = 4
//F(4) = 1 + 2 + 4 = 7
//So, F(1) + F(2) + F(3) + F(4)
//    = 1 + 3 + 4 + 7 = 15
//Input: n = 5
//Output: 21
//Explanation:
//F(1) = 1
//F(2) = 1 + 2 = 3
//F(3) = 1 + 3 = 4
//F(4) = 1 + 2 + 4 = 7
//F(5) = 1 + 5 = 6
//So,  F(1) + F(2) + F(3) + F(4) + F(5)
//    = 1 + 3 + 4 + 7 + 6 = 21
//Input: n = 1
//Output: 1
//Explanation:
//F(1) = 1
//So,  F(1) = 1
public class PrintAllDivisors {
    public static void main(String[] args) {
        System.out.println(sumOfDivisors(4));
    }

    public static int sumOfDivisors(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += (n/i)*i;
        }
        return sum;
    }
}
