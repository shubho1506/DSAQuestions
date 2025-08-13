package BitManipulation.Easy;

public class ConvertToBinary {
    public static void main(String[] args) {
        System.out.println(convert(35));
    }

    public static String convert(int num){
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(num % 2);
            num /= 2;
        }
        return ans.reverse().toString();
    }
}
