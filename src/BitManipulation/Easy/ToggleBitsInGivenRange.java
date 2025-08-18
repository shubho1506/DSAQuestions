package BitManipulation.Easy;

//Given a non-negative number n and two values l and r. The problem is to toggle the bits in the range l to r in the
// binary representation of n, i.e., to toggle bits from the lth least significant bit to the rth least significant bit
// (the rightmost bit as counted as the first bit).
//
//A toggle operation flips a bit 0 to 1 and a bit 1 to 0.
//
//Example 1:
//
//Input:
//n = 17 , l = 2 , r = 3
//Output:
//23
//Explanation:
//(17)10 = (10001)2.  After toggling all
//the bits from 2nd to 3rd position we get
//(10111)2 = (23)10
//Example 2:
//
//Input:
//n = 50 , l = 2 , r = 5
//Output:
//44
//Explanation:
//(50)10 = (110010)2.  After toggling all
//the bits from 2nd to 5th position we get
//(101100)2 = (44)10

public class ToggleBitsInGivenRange {
    public static void main(String[] args) {
        System.out.println(toggleBits(50,2,5));
    }

    static int toggleBits(int n, int l, int r) {
        while(l<=r){
            n = n^(1<<(l-1));
            l++;
        }
        return n;
    }
}
