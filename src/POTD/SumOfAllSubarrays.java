package POTD;

public class SumOfAllSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(subarraySum(arr));
    }

    public static int subarraySum(int[] arr) {
        // code here
        int n=arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            int cnt=(i+1)*(n-i); //count of how much time this index will come
            sum+=arr[i]*cnt;
        }
        return sum;
    }
}
