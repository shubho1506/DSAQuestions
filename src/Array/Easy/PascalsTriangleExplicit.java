package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleExplicit {
    public static void main(String[] args) {
        System.out.println(pascalsTriangleExplicit(5));
    }

    public static List<List<Long>> pascalsTriangleExplicit(int num){
        List<List<Long>> triangle = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            List<Long> row = new ArrayList<>();
            for (int k = 0; k <= n; k++) {
                row.add(combination(n, k));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static long factorial(int n) {
        if(n<=1)
            return 1;
        else
            return n*factorial(n-1);
    }



}
