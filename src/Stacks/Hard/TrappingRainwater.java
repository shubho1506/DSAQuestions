package Stacks.Hard;

//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.

//Example 1:
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.

//Example 2:
//Input: height = [4,2,0,3,2,5]
//Output: 9

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapBetter(height));
        System.out.println(trapOptimal(height));
    }


    public static int trapBetter(int[] height) {
        int[] lMax = new int[height.length];
        lMax[0] = height[0];
        int[] rMax = new int[height.length];
        rMax[height.length-1] = height[height.length-1];

        for(int i=1;i< height.length;i++){
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }

        for(int i=height.length-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1],height[i]);
        }

        int ans = 0;
        for(int i=0;i< height.length;i++){
            ans += Math.min(lMax[i],rMax[i]) - height[i];
        }

        return ans;
    }

    public static int trapOptimal(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        int lMax = 0;
        int rMax = 0;

        while(left<right){
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);

            if(lMax<rMax){
                ans += lMax-height[left];
                left++;
            }else{
                ans += rMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
