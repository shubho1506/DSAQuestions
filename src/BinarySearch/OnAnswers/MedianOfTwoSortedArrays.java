package BinarySearch.OnAnswers;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).

//Example 1:
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.

//Example 2:
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int si = 0;
        int ei = nums1.length;
        int left = (nums1.length + nums2.length + 1)/2;
        while (si<=ei){
            int mid1 = si + (ei-si)/2;
            int mid2 = left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1-1>=0){
                l1 = nums1[mid1-1];
            }
            if(mid2-1>=0){
                l2 = nums2[mid2-1];
            }
            if(mid1<nums1.length){
                r1=nums1[mid1];
            }
            if(mid2<nums2.length){
                r2=nums2[mid2];
            }

            if(l2<=r1 && l1<=r2){
                if((nums1.length+ nums2.length)%2==1){
                    return (double) Math.max(l1,l2);
                }else{
                    return ((double) (Math.max(l1,l2)+Math.min(r1,r2))/2);
                }
            } else if (l1>r2) {
                ei=mid1-1;
            }else {
                si=mid1+1;
            }
        }
        return 0;
    }
}
