package SlidingWindow_TwoPointer.Medium;

//You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
// by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of
// fruit each basket can hold.
//Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
// while moving to the right. The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.

//Example 1:
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.

//Example 2:
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].
//If we had started at the first tree, we would only pick from trees [0,1].

//Example 3:
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].
//If we had started at the first tree, we would only pick from trees [1,2].

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int maxFruits = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        while(right != fruits.length){
            hmap.put(fruits[right],hmap.getOrDefault(fruits[right],0)+1);
            while (hmap.size()>2){
                hmap.put(fruits[left],hmap.get(fruits[left])-1);
                if(hmap.get(fruits[left])==0){
                    hmap.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits,right-left+1);
            right++;
        }
        return maxFruits;
    }
}
