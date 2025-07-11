package POTD;

//Given an integer n, the task is to count the number of binary strings of length n that contains at least one pair
// of consecutive 1's.
//Note: A binary string is a sequence made up of only 0's and 1's.

//Examples:
//Input: n = 2
//Output: 1
//Explanation: There are 4 strings of length 2, the strings are 00, 01, 10, and 11. Only the string 11 has
//consecutive 1's.

//Input: n = 3
//Output: 3
//Explanation: There are 8 strings of length 3, the strings are 000, 001, 010, 011, 100, 101, 110 and 111.
// The strings with consecutive 1's are 011, 110 and 111.

//Input: n = 5
//Output: 19
//Explanation: There are 19 strings having at least one pair of consecutive 1's.

public class TrailingOnes {
    public static void main(String[] args) {
        System.out.println(countConsec(5));
    }
    public static int countConsec(int n) {
        if(n<2){
            return 0;
        }

        //good is those which do not have consecutive ones
        int a=2; //good(1) gonna  have 2
        int b=3; //good(2) gonna have 3

        for(int i=3; i<=n; i++){
            int temp = a+b;
            a = b;
            b = temp;
        }

        int total = (int)Math.pow(2,n);
        return total - b;
    }
}
