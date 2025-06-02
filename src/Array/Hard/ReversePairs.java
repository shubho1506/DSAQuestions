package Array.Hard;

//Given an integer array nums, return the number of reverse pairs in the array.
//A reverse pair is a pair (i, j) where:
//0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].

//Example 1:
//Input: nums = [1,3,2,3,1]
//Output: 2
//Explanation: The reverse pairs are:
//(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
//(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

//Example 2:
//Input: nums = [2,4,3,5,1]
//Output: 3
//Explanation: The reverse pairs are:
//(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
//(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
//(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int count=0;
        return mergeSort(nums,0,nums.length-1);
    }

    public static int mergeSort(int[] nums,int si,int ei){
        int count = 0;
        if(si>=ei){
            return 0;
        }
        int mid = si+(ei-si)/2;
        count += mergeSort(nums,si,mid);
        count += mergeSort(nums,mid+1, ei);

        count += merge(nums,si,mid,ei);
        return count;
    }

    public static int merge(int[] nums,int si,int mid,int ei){
        int count = 0;
        int j=mid+1;
        for(int i=si;i<=mid;i++){
            while(j<=ei && nums[i]>2*(long)nums[j]){
                j++;
            }
            count += j-(mid+1);
        }

        int[] merged = new int[ei-si+1];
        int id1 = si;
        int id2 = mid+1;
        int x  = 0;


        while(id1<=mid && id2<=ei){
            if(nums[id1]<=nums[id2]){
                merged[x++] = nums[id1++];
            }else {
                merged[x++] = nums[id2++];
            }
        }

        while (id1<=mid){
            merged[x++] = nums[id1++];
        }
        while (id2<=ei){
            merged[x++] = nums[id2++];
        }

        for (int i=0;i<merged.length;i++){
            nums[si++] = merged[i];
        }

        return count;
    }
}
