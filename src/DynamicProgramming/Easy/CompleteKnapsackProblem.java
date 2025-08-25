package DynamicProgramming.Easy;
//Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items
//in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized.
//Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single
//quantity.
//Examples :
//Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
//Output: 3
//Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

//Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
//Output: 0
//Explanation: Every item has a weight exceeding the knapsack's capacity (3).

//Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
//Output: 80
//Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

public class CompleteKnapsackProblem {
    public static void main(String[] args) {
        int W = 5;
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};
        System.out.println(knapSack(W, val, wt));
    }

    static int knapSack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] dp = new int[W+1];
        for(int i=0;i<n;i++){
            for(int j=W;j>=wt[i];j--){
                dp[j]=Math.max(dp[j],dp[j-wt[i]]+val[i]);
            }
        }
        return dp[W];
    }
}
