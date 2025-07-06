package POTD;

import java.util.*;

//You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[]
// and one from b[], using each index pair (i, j) at most once. Return the top k maximum sum combinations, sorted in
// non-increasing order.

//Examples:
//Input: a[] = [3, 2], b[] = [1, 4], k = 2
//Output: [7, 6]
//Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.

//Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
//Output: [10, 9, 9]
//Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9
class Pair{
    int i;
    int j;
    int sum;
    Pair(int i,int j,int sum){
        this.i=i;
        this.j=j;
        this.sum=sum;
    }
}

public class MaxSumCombination {
    public static void main(String[] args) {
        int[] a = {1, 4, 2, 3};
        int[] b = {2, 5, 1, 6};
        System.out.println(topKSumPairs(a,b,3));
    }

    //using maxHeap technique
    public static List<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.sum-p1.sum);
        Set<String> visited = new HashSet<>();

        int i = a.length-1;
        int j = b.length-1;

        List<Integer> ans = new ArrayList<>();
        pq.add(new Pair(i, j,a[i]+b[j]));

        while (k>0 && !pq.isEmpty()){

            Pair current = pq.poll();
            ans.add(current.sum);

            if (current.i - 1 >= 0) {
                String key1 = (current.i - 1) + "," + current.j;
                if (!visited.contains(key1)) {
                    pq.add(new Pair( current.i - 1, current.j,a[current.i - 1] + b[current.j]));
                    visited.add(key1);
                }
            }

            if (current.j - 1 >= 0) {
                String key1 = (current.i) + "," + (current.j-1);
                if (!visited.contains(key1)) {
                    pq.add(new Pair( current.i,current.j - 1, a[current.i] + b[current.j-1]));
                    visited.add(key1);
                }
            }

            k--;
        }

        return ans;
    }
}
