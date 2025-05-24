package Algorithms.Famous;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(4));;
    }

    public static boolean sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[n];
    }
}
