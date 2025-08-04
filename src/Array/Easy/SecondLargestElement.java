package Array.Easy;
//Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
//
//Note: The second largest element should not be equal to the largest element.
//
//Examples:
//
//Input: arr[] = [12, 35, 1, 10, 34, 1]
//Output: 34
//Explanation: The largest element of the array is 35 and the second largest element is 34.
//Input: arr[] = [10, 5, 10]
//Output: 5
//Explanation: The largest element of the array is 10 and the second largest element is 5.
//Input: arr[] = [10, 10, 10]
//Output: -1
//Explanation: The largest element of the array is 10 and the second largest element does not exist.
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        System.out.println(getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {
        int largest = arr[0];
        int slargest = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                slargest = largest;
                largest = arr[i];
            } else if (arr[i]<largest && arr[i]>slargest) {
                slargest = arr[i];
            }
        }

        return slargest;
    }
}
