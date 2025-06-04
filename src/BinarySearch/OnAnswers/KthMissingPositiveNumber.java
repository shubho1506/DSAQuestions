package BinarySearch.OnAnswers;

//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//Return the kth positive integer that is missing from this array.

//Example 1:
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

//Example 2:
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {2,3,4,7,11};
        System.out.println(findKthPositive(nums,5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int si=0;
        int ei = arr.length-1;

        while (si<=ei){
            int mid = si+(ei-si)/2;
            if((arr[mid]-(mid+1))>=k){
                ei=mid-1;
            }else {
                si=mid+1;
            }
        }
        return si+k;
    }
}
