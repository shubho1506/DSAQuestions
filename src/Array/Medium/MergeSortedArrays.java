package Array.Medium;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
//representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
//To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
//and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//Example 1:
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

//Example 2:
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].

//Example 3:
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {1,2,3,5,6};
        int n = 5;

        merge(nums1,m,nums2,n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1=0;
        int i2=0;

        int[] merged = new int[m+n];
        if(m==0){
            while(i1<nums1.length){
                nums1[i1++] = nums2[i2++];
            }
        }else if(m!=0 && n!=0){

            int id1=0;
            int id2=0;
            int id3=0;
            while(id1<m && id2<n){
                if(nums1[id1]<nums2[id2]){
                    merged[id3++] = nums1[id1++];
                }else if(nums1[id1]>nums2[id2]){
                    merged[id3++] = nums2[id2++];
                }else{
                    merged[id3++] = nums1[id1++];
                    merged[id3++] = nums2[id2++];
                }
            }

            if(id1<m){
                while(id1<m){
                    merged[id3++] = nums1[id1++];
                }
            }

            if(id2<n){
                while(id2<m){
                    merged[id3++] = nums2[id2++];
                }
            }
        }



        System.out.println(Arrays.toString(merged));
    }
}
