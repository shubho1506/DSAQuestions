package BitManipulation.Easy;

//You are given a number n. Find the total count of set bits for all numbers from 1 to n (both inclusive).
//
//Examples :
//
//Input: n = 4
//Output: 5
//Explanation: For numbers from 1 to 4. For 1: 0 0 1 = 1 set bits For 2: 0 1 0 = 1 set bits For 3: 0 1 1 = 2 set
// bits For 4: 1 0 0 = 1 set bits Therefore, the total set bits is 5.
//Input: n = 17
//Output: 35
//Explanation: From numbers 1 to 17(both inclusive), the total number of set bits is 35.

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println( countSetBits(4));;
    }

    public static int countSetBits(int n) {
        if (n == 0) return 0;

        // largest power of 2 <= n
        int x = largestPowerOf2(n);

        // count of set bits till 2^x - 1
        int bitsUpTo2x = x * (1 << (x - 1));

        // MSB contribution from 2^x to n
        int msbContribution = n - (1 << x) + 1;

        // recurse for remaining part
        int rest = countSetBits(n - (1 << x));

        return bitsUpTo2x + msbContribution + rest;
    }

    // function to find largest power of 2 exponent (floor of log2(n))
    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }
        return x;
    }
}
