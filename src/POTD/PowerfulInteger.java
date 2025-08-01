package POTD;

//You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end]
//represents a closed interval (i.e., all integers from start to end, inclusive).
//You are also given an integer k. An integer is called Powerful if it appears in at least k intervals.
//Find the maximum Powerful Integer.
//Note: If no integer occurs at least k times return -1.

//Examples:
//Input : n = 3, intervals[][] = [[1, 3], [4, 6], [3, 4]], k = 2
//Output: 4
//Explanation: Integers 3 and 4 appear in 2 intervals. The maximum is 4.

//Input : n = 4, intervals[][] = [[1, 4], [12, 45], [3, 8], [10, 12]], k = 3
//Output: -1
//Explanation: No integer appears in at least 3 intervals.

//Input : n = 5, intervals[][] = [[16, 21], [5, 8], [12, 17], [17, 29], [9, 24]], k = 3
//Output: 21
//Explanation: Integers 16, 17, 18, 19, 20 and 21 appear in at least 3 intervals. The maximum is 21.

import java.util.Map;
import java.util.TreeMap;

public class PowerfulInteger {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},{4, 6},{3, 4}};
        System.out.println(powerfulInteger(intervals,2));
    }

    public static int powerfulInteger(int[][] intervals, int k) {
        int maxEnd = 0;
        for(int[] arr : intervals){
            maxEnd = Math.max(maxEnd,arr[1]);
        }

        int[] counts = new int[maxEnd+2];
        for(int[] arr : intervals){
            counts[arr[0]] += 1;
           if(arr[1]+1<counts.length){
               counts[arr[1]+1] -= 1;
           }
        }

        int powInteger = -1;
        int current = 0;
        for(int i=1;i<counts.length;i++){
            current += counts[i];
            if(current>=k){
                powInteger = i;
            }
        }

        return powInteger;
    }

    public int powerfulInteger2(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map=new TreeMap<>();

        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            map.put(start, map.getOrDefault(start, 0)+1);
            map.put(end+1, map.getOrDefault(end+1, 0)-1);
        }

        int result=-1;
        int count=0;

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(val>=0){
                count+=val;
                if(count>=k){
                    result=key;
                }
            }else{
                if(count>=k){
                    result=key-1;
                }
                count+=val;
            }
        }

        return result;
    }
}
