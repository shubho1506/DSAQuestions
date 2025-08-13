package BitManipulation.Easy;

public class ConvertToNumber {
    public static void main(String[] args) {
        System.out.println(convert("11001"));
    }

    public static int convert(String num){
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            ans = ans * 2 + (num.charAt(i) - '0');
        }
        return ans;
    }
}
