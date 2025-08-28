package POTD;

//Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as
// lengths of three sides of the triangle. A triangle with three given sides is only possible if sum of any two sides
// is always greater than the third side.
//Examples:
//Input: arr[] = [4, 6, 3, 7]
//Output: 3
//Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.
//Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
//Output: 6
//Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300].
//Input: arr[] = [1, 2, 3]
//Output: 0
//Explanation: No triangles are possible.

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args) {
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        System.out.println(countTriangles(arr));
    }

    public static int countTriangles(int arr[]) {
        int count=0;
        if(arr.length<3){
            return 0;
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=2;i--){
            int left=0;
            int right=i-1;
            while(left<right){
                if(arr[left]+arr[right]>arr[i]){
                    count+=right-left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
    }
}
