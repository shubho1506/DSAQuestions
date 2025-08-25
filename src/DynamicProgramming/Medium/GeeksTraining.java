package DynamicProgramming.Medium;

//Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, and
//Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do
//the same activity on two consecutive days. Given a 2D array arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2]
//represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum
//total merit points Geek can achieve .
//Example:
//Input: arr[]= [[1, 2, 5], [3, 1, 1], [3, 3, 3]]
//Output: 11
//Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and
// on third day he will do fighting and earn 3 points so, maximum merit point will be 11.
//Input: arr[]= [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
//Output: 6
//Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his
// total merit points as 6.
//Input: arr[]= [[4, 2, 6]]
//Output: 6
//Explanation: Geek will learn a new move to make his merit points as 6.

public class GeeksTraining {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5},{3, 1, 1},{3, 3, 3}};
        System.out.println(maximumPoints(arr));
        System.out.println(maximumPointsTabulation(arr));
    }

    public static int maximumPoints(int[][] arr) {
        return maximumPointsRecursion(arr,arr.length-1,3);
    }

    private static int maximumPointsRecursion(int[][] arr,int day,int lastTask){
        if(day==0){
            int maxValue = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!= lastTask){
                    maxValue = Math.max(maxValue,arr[day][i]);
                }
            }
            return maxValue;
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i!=lastTask){
                int points = arr[day][i] + maximumPointsRecursion(arr,day-1,i);
                maxValue = Math.max(maxValue,points);
            }
        }
        return maxValue;
    }

    private static int maximumPointsTabulation(int[][] arr){
        int n = arr.length;
        int[][] dp = new int[n][4]; // dp[day][lastTask]
        // Base case: Day 0
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);   // lastTask = 0 (can't pick running)
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);   // lastTask = 1 (can't pick fighting)
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);   // lastTask = 2 (can't pick learning)
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // no restriction
        for(int day = 1;day <n;day++){
            for(int lastTask = 0;lastTask<4;lastTask++){
                int maxValue = Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++) {
                    if (task != lastTask) {
                        int points = arr[day][task] + dp[day - 1][task];
                        maxValue = Math.max(maxValue, points);
                    }
                }
                dp[day][lastTask] = maxValue;
            }
        }
        return dp[n-1][3];
    }
}
