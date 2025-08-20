package Algorithms.Famous;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(4));
        bitWiseSieve(15);
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

    static int ifnotPrime(int prime[], int x)
    {
        return (prime[x/64] & (1 << ((x >> 1) & 31)));
    }

    static void makeComposite(int prime[], int x)
    {
        prime[x/64] |= (1 << ((x >> 1) & 31));
    }

    static void bitWiseSieve(int n)
    {
        int prime[] = new int[n/64 + 1];
        for (int i = 3; i * i <= n; i += 2) {
            if (ifnotPrime(prime, i)==0){
                for (int j = i * i, k = i << 1; j < n; j += k){
                    makeComposite(prime, j);
                }
            }
        }
        System.out.printf("2 ");
        for (int i = 3; i <= n; i += 2){
            if (ifnotPrime(prime, i) == 0){
                System.out.printf("%d ", i);
            }
        }
    }
}
