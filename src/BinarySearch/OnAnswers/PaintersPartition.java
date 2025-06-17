package BinarySearch.OnAnswers;

//Given an array arr[] and k, where the array represents the boards and each element of the given array represents the length
// of each board. k numbers of painters are available to paint these boards. Consider that each unit of a board takes
// 1 unit of time to paint. The task is to find the minimum time to get this job done by painting all the boards under
// the constraint that any painter will only paint the continuous sections of boards. say board [2, 3, 4] or
// only board [1] or nothing but not board [2, 4, 5].
//Examples:

//Input: arr[] = [5, 10, 30, 20, 15], k = 3
//Output: 35
//Explanation: The most optimal way will be: Painter 1 allocation : [5,10], Painter 2 allocation : [30], Painter 3 allocation : [20, 15], Job will be done when all painters finish i.e. at time = max(5 + 10, 30, 20 + 15) = 35

//Input: arr[] = [10, 20, 30, 40], k = 2
//Output: 60
//Explanation: The most optimal way to paint: Painter 1 allocation : [10, 20, 30], Painter 2 allocation : [40], Job will be complete at time = 60

public class PaintersPartition {
    public static void main(String[] args) {
        int[] boards = {5, 10, 30, 20, 15};
        System.out.println(painterPartition(boards,3));
    }

    public static int painterPartition(int[] boards,int k){
        int si=0;
        int ei=0;
        for(int board : boards){
            ei+=board;
        }
        int ans = -1;
        while(si<=ei){
            int mid = si+(ei-si)/2;

            if(isPossible(boards,k,mid)){
                ans = mid;
                ei=mid-1;
            }else {
                si=mid+1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] boards,int painters,int maxBoards){
        int current = 1;
        int boardSum = 0;

        for(int board : boards){
            if(boardSum+board>maxBoards){
                current++;
                boardSum = board;
                if(current>painters){
                    return false;
                }
            }else {
                boardSum += board;
            }
        }
        return true;
    }
}
