package BitManipulation.Easy;

public class CheckIfNumberIsOddOrNot {
    public static void main(String[] args) {
        System.out.println(isOdd(34));
    }

    public static boolean isOdd(int num){
        return (num&1)==1;
    }
}
