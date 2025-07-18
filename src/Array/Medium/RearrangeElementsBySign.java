package Array.Medium;

//You are given a 0-indexed integer array nums of even length
// consisting of an equal number of positive and negative integers.
//You should return the array of nums such that the array follows the given conditions:
//
//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.
//Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

import java.util.ArrayList;
import java.util.Arrays;

//Example 1:
//
//Input: nums = [3,1,-2,-5,2,-4]
//Output: [3,-2,1,-5,2,-4]
//Explanation:
//The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
//The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
//Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are
// incorrect because they do not satisfy one or more conditions.
//Example 2:
//
//Input: nums = [-1,1]
//Output: [1,-1]
//Explanation:
//1 is the only positive integer and -1 the only negative integer in nums.
//So nums is rearranged to [1,-1].
public class RearrangeElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
        System.out.println(Arrays.toString(rearrangeArrayOptimized(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for(int i : nums){
            if(i>0){
                positives.add(i);
            }else {
                negatives.add(i);
            }
        }
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i] = positives.get(idx);
            }else{
                nums[i] = negatives.get(idx++);
            }
        }
        return nums;
    }

    public static int[] rearrangeArrayOptimized(int[] nums) {
        int ans[] = new int[nums.length];
        int positive = 0;
        int negative = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negative] = nums[i];
                negative += 2;
            }else{
                ans[positive] = nums[i];
                positive += 2;
            }
        }
        return ans;
    }
}
