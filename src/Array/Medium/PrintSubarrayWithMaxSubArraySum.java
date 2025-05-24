package Array.Medium;

public class PrintSubarrayWithMaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 8};
        System.out.println(printSubArrayWithMaxSubArraySum(arr));;
    }

    public static long printSubArrayWithMaxSubArraySum(int[] arr){
        long maxi = Long.MIN_VALUE;
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) start = i;
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("The subarray is: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }

        return maxi;
    }
}
