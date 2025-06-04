package Algorithms.Famous;

import java.util.List;

public class MooreVotingAlgo {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(mooreVoting(nums));
    }

    public static int mooreVoting(int[] nums) {
        int ans = 0;
        int freq = 0;

        for(int i=0;i<nums.length-1;i++){
            if(freq==0){
                ans = nums[i];
            }

            if(ans==nums[i]){
                freq++;
            }else {
                freq--;
            }
        }

        return ans;
    }
}
