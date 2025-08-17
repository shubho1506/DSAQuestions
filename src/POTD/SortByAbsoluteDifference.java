package POTD;

//You are given a number x and array arr[]. Your task is to rearrange the elements of the array according to the
// absolute difference with x, i.e., an element having minimum difference comes first, and so on.
//Note: If two or more elements are at equal distances arrange them in the same sequence as in the given array.
//Examples:
//Input: x = 7, arr[] = [10, 5, 3, 9, 2]
//Output: [5, 9, 10, 3, 2]
//Explanation: Sorting the numbers according to the absolute difference with 7, we have array elements as 5, 9, 10, 3, 2.
//Input: x = 6, arr[] = [1, 2, 3, 4, 5]
//Output: [5, 4, 3, 2, 1]
//Explanation: Sorting the numbers according to the absolute difference with 6, we have array elements as 5, 4, 3, 2, 1.


import java.util.*;

public class SortByAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 9, 2};
        rearrangeT(arr,7);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrangeT(int[] arr, int x) {
        TreeMap<Integer, List<Integer>> tmap =new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int diff=Math.abs(arr[i]-x);
            if(!tmap.containsKey(diff)){
                List<Integer> li=new ArrayList<>();
                li.add(arr[i]);
                tmap.put(diff,li);
            }
            else{
                tmap.get(diff).add(arr[i]);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry: tmap.entrySet()){
            ans.addAll(entry.getValue());
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
        }
    }

    public static void rearrangeC(int[] arr, int x) {
        ArrayList<Integer> arrl =new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arrl.add(arr[i]);
        }
        Collections.sort(arrl, Comparator.comparingInt(a -> Math.abs(a - x)));
        for(int i=0;i<arr.length;i++){
            arr[i]= arrl.get(i);
        }
    }
}
