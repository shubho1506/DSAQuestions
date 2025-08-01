package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(4));
    }

    public static List<List<Integer>> generate(int num) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arr.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr.get(i).add(1);
                } else {
                    int val = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j);
                    arr.get(i).add(val);
                }
            }
        }
        return arr;
    }
}
