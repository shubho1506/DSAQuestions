package BinarySearch.OneDimensionalArrays;

//Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
// The lower bound algorithm finds the first or the smallest index in a sorted array where the value
// at that index is greater than or equal to a given key i.e. x.
//If no such index is found, return the size of the array.

//Examples:
//Input : nums= [1,2,2,3], x = 2
//Output:1
//Explanation: Index 1 is the smallest index such that arr[1] >= x.

//Input : nums= [3,5,8,15,19], x = 9
//Output: 3
//Explanation: Index 3 is the smallest index such that arr[3] >= x.

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(lowerBound(nums,2));
    }

    public static int lowerBound(int[] nums, int x) {
        int si=0;
        int ei=nums.length-1;

        int ans = -1;

        if(nums.length==1){
            return nums[0];
        }

        while (si<=ei){
            int mid = si+(ei-si)/2;

            if(nums[mid]>=x){
                ans = mid;
                ei = mid-1;
            } else if (nums[mid]<x) {
                si=mid+1;
            }
        }
        return ans;
    }
}
