package Array.Hard;

//Given an integer array nums. Return the number of inversions in the array.
//Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
//It indicates how close an array is to being sorted.
//A sorted array has an inversion count of 0.
//An array sorted in descending order has maximum inversion.

//Examples:
//Input: nums = [2, 3, 7, 1, 3, 5]
//Output: 5
//Explanation: The responsible indexes are:
//nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
//nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
//nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
//nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
//nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

//Input: nums = [-10, -5, 6, 11, 15, 17]
//Output: 0
//Explanation: nums is sorted, hence no inversions present.

public class CountInversions {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(nums));
    }

    public static long numberOfInversions(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    static int mergeSort(int[] arr,int si,int ei){
        if(si>=ei){
            return 0;
        }
        int mid = si+(ei-si)/2;
        int leftInversionCount = mergeSort(arr,si,mid);
        int rightInversionCount = mergeSort(arr,mid+1, ei);

        int inversionCount = merge(arr,si,mid,ei);

        return leftInversionCount+rightInversionCount+inversionCount;
    }

    static int merge(int[] arr,int si,int mid,int ei){
        int[] merged = new int[ei-si+1];
        int id1=si;
        int id2=mid+1;
        int x=0;
        int countInversion = 0;
        while(id1<=mid && id2<=ei){
            if(arr[id1]<=arr[id2]){
                merged[x++] = arr[id1++];
            }else {
                merged[x++] = arr[id2++];
                countInversion += (mid-id1+1);
            }
        }
        while (id1<=mid){
            merged[x++] = arr[id1++];
        }
        while (id2<=ei){
            merged[x++] = arr[id2++];
        }

        for (int i=0;i<merged.length;i++){
            arr[si++] = merged[i];
        }
        return countInversion;
    }
}
