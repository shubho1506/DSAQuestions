package BinarySearch.OnAnswers;

//Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
// divide all the array by it, and sum the division's result. Find the smallest divisor such that the result
//mentioned above is less than or equal to threshold.
//Each result of the division is rounded to the nearest integer greater than or equal to that element.
// (For example: 7/3 = 3 and 10/2 = 5).
//The test cases are generated so that there will be an answer.

//Example 1:
//Input: nums = [1,2,5,9], threshold = 6
//Output: 5
//Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
//If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

//Example 2:
//Input: nums = [44,22,33,11,1], threshold = 5
//Output: 44

public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        System.out.println(smallestDivisor(nums,5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int si=1;
        int ei=Integer.MIN_VALUE;

        for(int i : nums){
            ei = Math.max(ei,i);
        }

        int ans = 0;

        while (si <= ei) {
            int mid = si+(ei-si)/2;
            int sum = isPossible(nums,mid,threshold);
            if(sum<=threshold){
                ans = mid;
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return ans;
    }

    public static int isPossible(int[] nums,int divisor,int threshold){
        int sum = 0;
        for(int i : nums){
            if((i%divisor!=0)){
                sum+= (i/divisor)+1;
            }else {
                sum += (i/divisor);
            }
        }
        return sum;
    }
}
