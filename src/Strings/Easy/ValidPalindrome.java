package Strings.Easy;

import java.util.SplittableRandom;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(str));
    }

    public static boolean isValidPalindrome(String str){
        str = str.replaceAll("[^A-Z0-9a-z]","").toLowerCase();
        int id1=0;
        int id2=str.length()-1;
        while (id1<id2){
            if(str.charAt(id1++) != str.charAt(id2--)){
                return false;
            }
        }
        return true;
    }
}
