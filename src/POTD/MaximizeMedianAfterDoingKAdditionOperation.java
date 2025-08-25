package POTD;

//Given an array arr[] consisting of positive integers and an integer k. You are allowed to perform at most k operations,
// where in each operation, you can increment any one element of the array by 1. Determine the maximum possible median
// of the array that can be achieved after performing at most k such operations.
//Note: The median of a sorted array is the middle element if the size is odd, or the average of the two middle elements
// if the size is even.
//Examples:
//Input: arr[] = [1, 3, 4, 5], k = 3
//Output: 5
//Explanation: We can add +2 to the second element and +1 to the third element to get the array [1, 5, 5, 5].
// After sorting, the array remains [1, 5, 5, 5]. Since the length is even, the median is (5 + 5) / 2 = 5.
//Input: arr[] = [1, 3, 6, 4, 2], k = 10
//Output: 7
//Explanation: After applying operations optimally, we can transform the array to [1, 3, 7, 7, 7] (one possible way).
//Sorted array becomes [1, 3, 7, 7, 7]. Since the length is odd, the median is the middle element 7.

import java.util.Arrays;

public class MaximizeMedianAfterDoingKAdditionOperation {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 2};
        System.out.println(maximizeMedian(arr,10));
    }

    public static int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int md = (n-1)/2;
        long sm = k;
        int sz = 1,ans = k+arr[md];
        if(n%2==0){
            ans=(ans+arr[md+1])/2;
            sm+=arr[md++];
            sz++;
        }
        for(int i=md;i<n;i++){
            sm+=arr[i];
            int hf = (int)(sm/sz++);
            ans=Math.min(ans,hf);
        }
        return ans;
    }


}
