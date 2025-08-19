package Algorithms.NotSoFamous;

public class BrianKernighanAlgo {
    public static void main(String[] args) {
        System.out.println(countSetBits(7));
    }

    public static int countSetBits(int num){
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
}
