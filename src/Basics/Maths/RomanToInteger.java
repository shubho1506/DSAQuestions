package Basics.Maths;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInteger("XIV"));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> hmap = new HashMap();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        int ans = 0;

        for(int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 1 && (Integer) hmap.get(s.charAt(i)) < (Integer) hmap.get(s.charAt(i + 1))) {
                ans -= (Integer) hmap.get(s.charAt(i));
            } else {
                ans += (Integer) hmap.get(s.charAt(i));
            }
        }

        return ans;
    }
}
