package POTD;

public class DivisiblityBy13 {
    public static void main(String[] args) {
        System.out.println(divby13("133468431"));
    }

    public static boolean divby13(String s) {
        int len = s.length();

        if (len % 3 == 1) {
            s += "00";
            len += 2;
        } else if (len % 3 == 2) {
            s += "0";
            len += 1;
        }

        int sum = 0;
        int p = 1;


        for (int i = len - 1; i >= 0; i--) {
            int group = 0;
            group += s.charAt(i--) - '0';
            group += (s.charAt(i--) - '0') * 10;
            group += (s.charAt(i) - '0') * 100;

            sum += group * p;
            p *= -1;
        }

        sum = Math.abs(sum);
        return sum % 13 == 0;
    }
}
