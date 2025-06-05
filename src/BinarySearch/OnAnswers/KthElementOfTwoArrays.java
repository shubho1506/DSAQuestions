package BinarySearch.OnAnswers;

//Given two sorted arrays a[] and b[] and an element k,
//the task is to find the element that would be at the kth position of the combined sorted array.

//Examples :
//Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
//Output: 6
//Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

//Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
//Output: 256
//Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892].
//The 7th element of this array is 256.

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        System.out.println(kthElement(a,b,5));
    }

    public static int kthElement(int[] a, int[] b, int k) {
        if(a.length>b.length){
            return kthElement(b,a,k);
        }
        int si = Math.max(k-b.length,0);
        int ei = Math.min(k,a.length);
        int left = k;
        while (si<=ei){
            int mid1 = si + (ei-si)/2;
            int mid2 = left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1-1>=0){
                l1 = a[mid1-1];
            }
            if(mid2-1>=0){
                l2 = b[mid2-1];
            }
            if(mid1<a.length){
                r1=a[mid1];
            }
            if(mid2<b.length){
                r2=b[mid2];
            }

            if(l2<=r1 && l1<=r2){
                return Math.max(l1,l2);
            } else if (l1>r2) {
                ei=mid1-1;
            }else {
                si=mid1+1;
            }
        }
        return -1;
    }
}
