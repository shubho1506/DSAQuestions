package Array.Medium;

import java.util.HashMap;

public class CountSubArraysWithSumK {
    public static void main(String[] args) {
        int[] nums = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(subarraySum(nums,k));
    }

    public static int countSubarrays(int arr[], int k) {
        int count = 0;
        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            for (int end = start; end < arr.length; end++) {
                sum += arr[end];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int sum=0;
        int count=0;
        map.put(0,1);

        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            System.out.println(map);
            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            System.out.println("count: "+count);
        }
        return count;
    }
}
