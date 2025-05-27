package BinarySearch.OneDimensionalArrays;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[2];
        if(nums.length==0){
            Arrays.fill(indexes,-1);
            return indexes;
        }

        int si=0;
        int ei= nums.length-1;

        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(nums[mid]>target){
                ei=mid-1;
            }else if(nums[mid]<target){
                si=mid+1;
            }else{
                int id1=mid;
                int id2=mid;
                while(id1>0 && nums[id1-1]==target ){
                    id1--;
                }
                while(id2<nums.length-1 && nums[id2+1]==target){
                    id2++;
                }
                indexes[0] = id1;
                indexes[1] = id2;
                return indexes;
            }
        }
        Arrays.fill(indexes,-1);
        return indexes;
    }
}
