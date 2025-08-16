package POTD;

public class IsPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
