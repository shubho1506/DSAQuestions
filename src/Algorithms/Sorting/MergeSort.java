package Algorithms.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,3,2,5,1,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        divide(arr,0,arr.length-1);
    }

    public static void divide(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid  = si + (ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,arr.length-1);
        conquer(arr,si,mid,arr.length-1);
    }

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei-si+1];
        int id1=si;
        int id2=mid+1;
        int x=0;
        while(id1<=mid && id2<=ei){
            if(arr[id1]<arr[id2]){
                merged[x++] = arr[id1++];
            }else {
                merged[x++] = arr[id2++];
            }
        }
        while (id1<=mid){
            merged[x++] = arr[id1++];
        }
        while (id2<=ei){
            merged[x++] = arr[id2++];
        }

        for (int i=0;i<merged.length;i++){
            arr[si++] = merged[i];
        }
    }
}
