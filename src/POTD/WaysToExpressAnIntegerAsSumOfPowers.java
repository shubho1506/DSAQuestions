package POTD;

//Given two positive integers n and x.
//Return the number of ways n can be expressed as the sum of the xth power of unique positive integers,
// in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
//Since the result can be very large, return it modulo 109 + 7.
//For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

//Example 1:
//Input: n = 10, x = 2
//Output: 1
//Explanation: We can express n as the following: n = 32 + 12 = 10.
//It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.

//Example 2:
//Input: n = 4, x = 1
//Output: 2
//Explanation: We can express n in the following ways:
//- n = 41 = 4.
//- n = 31 + 11 = 4.

import java.util.HashMap;
import java.util.Map;

public class WaysToExpressAnIntegerAsSumOfPowers {
    static int modulo = (int) (1e9 + 7);

    public static void main(String[] args) {
        System.out.println(numberOfWays(4, 1)); // Expected: 2
    }

    public static int numberOfWays(int n, int x) {
        return solve(n, 1, x, new HashMap<>());
    }

    private static int solve(int n, int num, int x, Map<String, Integer> memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        String key = n + "," + num;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currPower = (int) Math.pow(num, x);
        if (currPower > n) {
            return 0;
        }

        int take = solve(n - currPower, num + 1, x, memo) % modulo;
        int skip = solve(n, num + 1, x, memo) % modulo;

        int total = (take + skip) % modulo;
        memo.put(key, total);
        return total;
    }

    public static int numberOfWaysTable(int n, int x) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i,x) <= n; i++) {
            int num = (int)Math.pow(i,x);
            for (int s = n; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return (int) (dp[n] % 1_000_000_007);

    }
}
