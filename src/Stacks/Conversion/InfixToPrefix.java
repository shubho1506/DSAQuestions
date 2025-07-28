package Stacks.Conversion;

public class InfixToPrefix {
    static String convertToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();
        infix = sb.toString();

        char[] chars = infix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(a-b/c)*(a/k-l)";
        System.out.println(convertToPrefix(s));
    }
}
