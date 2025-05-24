package Array.Medium;
import java.util.Arrays;

//Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays.
// The elements in the union must be in ascending order.

//The union of two arrays is an array where all values are distinct and are present in either the first array,
//the second array, or both.

//Examples:
//Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
//
//Output: [1, 2, 3, 4, 5, 7]
//
//Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
//
//Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
//
//Output: [1, 3, 4, 5, 6, 7, 8, 9]
//
//Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 7, 9, 9};
        int[] nums2 = {1, 5, 7, 8, 8};
        System.out.println(Arrays.toString(unionArraywithDuplicates(nums1,nums2)));
    }

    public static int[] unionArraywithDuplicates(int[] nums1, int[] nums2){
        int[] merged  = new int[nums1.length+ nums2.length];
        int id1 = 0;
        int id2 = 0;
        int i = 0;
        while(id1< nums1.length && id2 < nums2.length){
            if(nums1[id1]<=nums2[id2]){
                merged[i++] =  nums1[id1++];
            }else{
                merged[i++] = nums2[id2++];
            }
        }
        while (id1<nums1.length){
            merged[i++] = nums1[id1++];
        }

        while (id2<nums2.length){
            merged[i++] = nums1[id2++];
        }
        return merged;
    }

//
//    public static int[]  unionArrayWithoutDuplicates(int[] nums1, int[] nums2){
//
//    }
}
