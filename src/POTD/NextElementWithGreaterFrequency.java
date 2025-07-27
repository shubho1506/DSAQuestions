package POTD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher
//frequency than the current element.
//If no such element exists, return -1 for that position.

//Examples:

//Input: arr[] = [2, 1, 1, 3, 2, 1]
//Output: [1, -1, -1, 2, 1, -1]
//Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
//For arr[0] = 2, the next element 1 has a higher frequency → 1.
//For arr[1] and arr[2], no element to the right has a higher frequency → -1.
//For arr[3] = 3, the next element 2 has a higher frequency → 2.
//For arr[4] = 2, the next element 1 has a higher frequency → 1.
//For arr[5] = 1, no elements to the right → -1.

//Input: arr[] = [5, 1, 5, 6, 6]
//Output: [-1, 5, -1, -1, -1]
//Explanation: Frequencies: 1 → 1 time, 5 → 2 times, 6 → 2 times.
//For arr[0] and arr[2], no element to the right has a higher frequency → -1.
//For arr[1] = 1, the next element 5 has a higher frequency → 5.
//For arr[3] and arr[4], no element to the right has a higher frequency → -1.

public class NextElementWithGreaterFrequency {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5, 6, 6};
        System.out.println(findGreater(arr));
    }

    public static ArrayList<Integer> findGreater(int[] arr) {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        ArrayList<Integer> arrl = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            hmp.put(i,hmp.getOrDefault(i,0)+1);
        }

        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && hmp.get(arr[i])>hmp.get(arr[stack.peek()])){
                arrl.set(stack.pop(), arr[i]);
            }
            arrl.add(-1);
            stack.push(i);
        }
        return arrl;
    }
}
