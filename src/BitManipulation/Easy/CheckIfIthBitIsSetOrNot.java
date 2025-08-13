package BitManipulation.Easy;

//Given two positive integer n and  k, check if the kth index bit of n is set or not.
// Note: A bit is called set if it is 1.
//Examples :
//Input: n = 4, k = 0
//Output: false
//Explanation: Binary representation of 4 is 100, in which 0th index bit from LSB is not set. So, return false.

//Input: n = 4, k = 2
//Output: true
//Explanation: Binary representation of 4 is 100, in which 2nd index bit from LSB is set. So, return true.

//Input: n = 500, k = 3
//Output: false
//Explanation: Binary representation of 500 is 111110100, in which 3rd index bit from LSB is not set. So, return false.

public class CheckIfIthBitIsSetOrNot {
    public static void main(String[] args) {
        System.out.println(checkKthBitL(4,2));
        System.out.println(checkKthBitR(4,2));
    }

    static boolean checkKthBitL(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    static boolean checkKthBitR(int n,int k){
        return ((n>>k)&1)==1;
    }

}
