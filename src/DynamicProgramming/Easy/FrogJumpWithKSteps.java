package DynamicProgramming.Easy;


import java.util.Arrays;

public class FrogJumpWithKSteps {
    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 20, 50};
        System.out.println(minCostTabulation(heights,3));
    }

    public static int minCostTabulation(int[] heights,int k){
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int cost = dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    dp[i]=Math.min(dp[i],cost);
                }
            }
        }
        return dp[n-1];
    }
}
