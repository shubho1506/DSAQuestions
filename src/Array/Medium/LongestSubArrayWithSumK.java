package Array.Medium;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 3, 5};
        int k = 5;
        System.out.println("Longest Subarray Length: " + longestSubArrayWithSumK(arr, k));
    }

    public static int longestSubArrayWithSumK(int arr[], int k) {
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while (right < arr.length) {
            sum += arr[right];
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }
}
