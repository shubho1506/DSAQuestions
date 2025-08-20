package BitManipulation.Medium;

//Given an integer n, return the number of prime numbers that are strictly less than n.
//Example 1:
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//Example 2:
//Input: n = 0
//Output: 0
//Example 3:
//Input: n = 1
//Output: 0

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        if (n <= 2) return 0;   // no primes < 2

        int prime[] = new int[n / 64 + 1];  // bit array
        int count = 1;  // counting "2" as prime

        // sieve process
        for (int i = 3; i * i < n; i += 2) {
            if (ifnotPrime(prime, i) == 0) {  // i is prime
                for (int j = i * i, k = i << 1; j < n; j += k) {
                    makeComposite(prime, j);
                }
            }
        }

        // count remaining primes
        for (int i = 3; i < n; i += 2) {
            if (ifnotPrime(prime, i) == 0) {
                count++;
            }
        }
        return count;
    }

    static int ifnotPrime(int prime[], int x) {
        return (prime[x / 64] & (1 << ((x >> 1) & 31)));
    }

    static void makeComposite(int prime[], int x) {
        prime[x / 64] |= (1 << ((x >> 1) & 31));
    }
}
