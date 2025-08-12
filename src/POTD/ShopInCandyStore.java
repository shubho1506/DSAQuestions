package POTD;

//In a candy store, there are different types of candies available and prices[i] represent the price of
// ith types of candies. You are now provided with an attractive offer.
//For every candy you buy from the store, you can get up to k other different candies for free. Find the
// minimum and maximum amount of money needed to buy all the candies.
//Note: In both cases, you must take the maximum number of free candies possible during each purchase.

//Examples :
//Input: prices[] = [3, 2, 1, 4], k = 2
//Output: [3, 7]
//Explanation: As according to the offer if you buy one candy you can take at most k more for free. So in the
//first case, you buy the candy worth 1 and takes candies worth 3 and 4 for free, also you need to buy candy worth 2.
// So min cost: 1+2 = 3. In the second case, you can buy the candy worth 4 and takes candies worth 1 and 2 for free,
// also you need to buy candy worth 3. So max cost: 3+4 = 7.

//Input: prices[] = [3, 2, 1, 4, 5], k = 4
//Output: [1, 5]
//Explanation: For minimimum cost buy the candy with the cost 1 and get all the other candies for free.
// For maximum cost buy the candy with the cost 5 and get all other candies for free.

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStore {
    public static void main(String[] args) {
        int[] prices = {3, 2, 1,5,4};
        System.out.println(minMaxCandy(prices,2));
    }

    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
//        int left = 0;
//        int right = prices.length-1;
//        int min = 0;
//        Arrays.sort(prices);
//        while (right>=left){
//            min += prices[left];
//            left++;
//            right-=k;
//        }
//        ans.add(min);
//        left = 0;
//        right = prices.length-1;
//        int max = 0;
//        while (right>=left){
//            max += prices[right];
//            right--;
//            left+=k;
//        }
//        ans.add(max);
//        return ans;
        int left1 = 0;
        int left2 = 0;
        int right1 = prices.length-1;
        int right2 = prices.length-1;
        int max = 0;
        int min = 0;
        Arrays.sort(prices);
        while (right1>=left1 && right2>=left2){
            max += prices[right1];
            right1--;
            left1+=k;
            min += prices[left2];
            left2++;
            right2-=k;
        }
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
