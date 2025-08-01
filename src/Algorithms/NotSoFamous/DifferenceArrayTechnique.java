package Algorithms.NotSoFamous;

public class DifferenceArrayTechnique {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},{4, 6},{3, 4}};
        System.out.println(diffArrayTechnique(intervals,2));
    }

    public static int diffArrayTechnique(int[][] arrs,int k){
        int maxEnd = 0;
        for(int[] arr : arrs){
            maxEnd = Math.max(maxEnd,arr[1]);
        }

        int[] counts = new int[maxEnd+2];
        for(int[] arr : arrs){
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
}
