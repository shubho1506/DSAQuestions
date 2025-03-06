package Basics.Maths;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }

    public static boolean isArmstrong(int num){
        int originalNum = num, sum = 0, count = 0, temp = num;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, count);
            temp /= 10;
        }
        return sum == originalNum;
    }
}
