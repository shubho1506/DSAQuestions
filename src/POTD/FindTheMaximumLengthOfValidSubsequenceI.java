package POTD;

//You are given an integer array nums.
//A subsequence sub of nums with length x is called valid if it satisfies:
//(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
//Return the length of the longest valid subsequence of nums.
//A subsequence is an array that can be derived from another array by deleting some or no elements
// without changing the order of the remaining elements.

//Example 1:
//Input: nums = [1,2,3,4]
//Output: 4
//Explanation:
//The longest valid subsequence is [1, 2, 3, 4].

//Example 2:
//Input: nums = [1,2,1,1,2,1,2]
//Output: 6
//Explanation:
//The longest valid subsequence is [1, 2, 1, 2, 1, 2].

//Example 3:
//Input: nums = [1,3]
//Output: 2
//Explanation:
//The longest valid subsequence is [1, 3].

public class FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,2,1,2};
        System.out.println(maximumLength(nums));
    }

    public static int maximumLength(int[] nums) {
        int oddCount = 0;
        int evenCount = 0;
        int count = 0;
        boolean flag = (nums[0]%2==1);

        for(int num : nums){
            if(num%2==1){
                if(flag){
                    flag = !flag;
                    count++;
                }
                oddCount++;
            }else{
                if(!flag){
                    flag = !flag;
                    count++;
                }
                evenCount++;
            }
        }

        return Math.max(count,Math.max(oddCount,evenCount));
    }
}
