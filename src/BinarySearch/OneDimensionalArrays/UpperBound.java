package BinarySearch.OneDimensionalArrays;

//Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at
// that index is greater than a given key i.e. x.
//If no such index is found, return the size of the array.

//Examples:
//Input : n= 4, nums = [1,2,2,3], x = 2
//Output:3
//Explanation: Index 3 is the smallest index such that arr[3] > x.

//Input : n = 5, nums = [3,5,8,15,19], x = 9
//Output: 3
//Explanation: Index 3 is the smallest index such that arr[3] > x.

public class UpperBound {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(upperBound(nums,2));
    }

    public static int upperBound(int[] nums, int x) {
        int si=0;
        int ei= nums.length-1;

        int ans=-1;

        while (si<=ei){
            int mid = si+(ei-si)/2;
            if(nums[mid]<=x){
                si=mid+1;
            }else {
                ans = mid;
                ei=mid-1;
            }
        }
        return ans;
    }
}

