package DynamicProgramming.Easy;

//Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first
// stair and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair
// or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs.
// Determine the minimum total cost required for the frog to reach the top.
//Example:
//Input: heights[] = [20, 30, 40, 20]
//Output: 20
//Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
//jump from stair 0 to 1: cost = |30 - 20| = 10
//jump from stair 1 to 3: cost = |20-30|  = 10
//Total Cost = 10 + 10 = 20

//Input: heights[] = [30, 20, 50, 10, 40]
//Output: 30
//Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
//jump from stair 0 to 2: cost = |50 - 30| = 20
//jump from stair 2 to 4: cost = |40-50|  = 10
//Total Cost = 20 + 10 = 30

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {30, 20, 50, 10, 40};
        System.out.println(minCostRecusion(heights));
        System.out.println(minCostTabulation(heights));
    }

    public static int minCostRecusion(int[] height) {
        int n = height.length;
        return solve(n - 1, height);
    }

    private static int solve(int index,int[] ht){
        if (index == 0){
            return 0;
        }
        if (index == 1){
            return Math.abs(ht[1] - ht[0]);
        }
        int one = solve(index - 1, ht) + Math.abs(ht[index] - ht[index - 1]);
        int two = solve(index - 2, ht) + Math.abs(ht[index] - ht[index - 2]);
        return Math.min(one, two);
    }

    public static int minCostTabulation(int[] height){
        int n = height.length;
        int[] dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int oneStep = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = dp[i-2]+Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(oneStep,twoStep);
        }
        return dp[n-1];
    }
}
