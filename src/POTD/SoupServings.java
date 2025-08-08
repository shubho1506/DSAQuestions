package POTD;

//You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations
// is chosen at random, each with probability 0.25 independent of all previous turns:
//pour 100 mL from type A and 0 mL from type B
//pour 75 mL from type A and 25 mL from type B
//pour 50 mL from type A and 50 mL from type B
//pour 25 mL from type A and 75 mL from type B
//Note:
//There is no operation that pours 0 mL from A and 100 mL from B.
//The amounts from A and B are poured simultaneously during the turn.
//If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.
//The process stops immediately after any turn in which one of the soups is used up.
//Return the probability that A is used up before B, plus half the probability that both soups are used up in the
// same turn. Answers within 10-5 of the actual answer will be accepted.

//Example 1:
//Input: n = 50
//Output: 0.62500
//Explanation:
//If we perform either of the first two serving operations, soup A will become empty first.
//If we perform the third operation, A and B will become empty at the same time.
//If we perform the fourth operation, B will become empty first.
//So the total probability of A becoming empty first plus half the probability that A and B become empty at the
// same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
//Example 2:
//Input: n = 100
//Output: 0.71875
//Explanation:
//If we perform the first serving operation, soup A will become empty first.
//If we perform the second serving operations, A will become empty on performing operation [1, 2, 3], and both A and B
// become empty on performing operation 4.
//If we perform the third operation, A will become empty on performing operation [1, 2], and both A and B become
// empty on performing operation 3.
//If we perform the fourth operation, A will become empty on performing operation 1, and both A and B become empty on
// performing operation 2.
//So the total probability of A becoming empty first plus half the probability that A and B become empty at
// the same time, is 0.71875.

import java.util.ArrayList;
import java.util.List;

public class SoupServings {
    static class Serve{
        int A;
        int B;
        Serve(int a,int b){
            this.A=a;
            this.B=b;
        }
    }
    static ArrayList<Serve> serves = new ArrayList<>(List.of(new Serve(100,0),new Serve(75,25)
            ,new Serve(50,50),new Serve(25,75)));
    private static Double[][] cache;

    public static void main(String[] args) {
        System.out.println(soupServings1(50));
        System.out.println(soupServings2(50));
    }

    public static double soupServings1(int n) {
        return soupServingsRecursion(n,n);
    }

    public static double soupServings2(int n) {
        if (n > 5000){
            return 1.0;
        }

        int units = (int) Math.ceil(n / 25.0);
        cache = new Double[units + 1][units + 1];
        return soupServingsMemo(units, units);
    }

    //explaining the base cases :- My desired outcome is ki A gets empty before B
    //so If it happens then it means that I won so its means 1.0


    public static double soupServingsRecursion(int A,int B) {
        if(A<=0 && B<=0){
            return 0.5;
        }
        if(A<=0){
            return 1.0;
        }
        if(B<=0){
            return 0.0;
        }
        double prob = 0.0;

        for(Serve serve : serves){
            int a_taken = serve.A;
            int b_taken = serve.B;
            prob += soupServingsRecursion(A-a_taken,B-b_taken);
        }

        return (0.25)*prob;
    }

    public static double soupServingsMemo(int soupA, int soupB){
        if (soupA <= 0 && soupB <= 0){
            return 0.5;
        }
        if (soupA <= 0){
            return 1.0;
        }
        if (soupB <= 0){
            return 0.0;
        }

        if (cache[soupA][soupB] != null){
            return cache[soupA][soupB];
        }

        double prob = 0.25 * (
                soupServingsMemo(soupA - 4, soupB) +
                        soupServingsMemo(soupA - 3, soupB - 1) +
                        soupServingsMemo(soupA - 2, soupB - 2) +
                        soupServingsMemo(soupA - 1, soupB - 3)
        );

        cache[soupA][soupB] = prob;
        return prob;

    }
}
