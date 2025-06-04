package BinarySearch.OnAnswers;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
//The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
//and eats k bananas from that pile. If the pile has less than k bananas,
// she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours.

//Example 1:
//Input: piles = [3,6,7,11], h = 8
//Output: 4

//Example 2:
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30

//Example 3:
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int[] edge = {805306368,805306368,805306368};
        System.out.println(minEatingSpeed(edge,1000000000));
    }

    public static int minEatingSpeed(int[] piles, int hours) {
        int si = 1;
        int ei = Integer.MIN_VALUE;

        for(int i : piles){
            ei = Math.max(ei,i);
        }
        int ans = -1;
        while (si<=ei){
            int mid = si+(ei-si)/2;
            int time = kokoBanana(piles,mid,hours);

            if(time>hours){
                si = mid+1;
            }else{
                ans = mid;
                ei = mid-1;
            }
        }

        return ans;
    }

    public static int kokoBanana(int[] piles,int speed,int hours){
        long time = 0;

        for (int i : piles) {
            time += (i + (long)speed - 1) / speed; // ceiling division
            if (time > hours) {
                return Integer.MAX_VALUE; // no need to keep going
            }
        }

        return (int)time;
    }
}
