package POTD;

import java.util.ArrayList;

//You are given an array of integer arr[] where each number represents a vote to a candidate.
// Return the candidates that have votes greater than one-third of the total votes,
// If there's not a majority vote, return an empty array.
//Note: The answer should be returned in an increasing format.

//Examples:
//Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
//Output: [5, 6]
//Explanation: 5 and 6 occur more n/3 times.

//Input: arr[] = [1, 2, 3, 4, 5]
//Output: []
//Explanation: The total number of votes are 5. No candidate occur more than floor (5/3) times.

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(arr));
    }

    public static ArrayList<Integer> findMajority(int[] arr) {

        int possNum1 = 0;
        int possNum2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int num : arr){
            if(num==possNum1){
                count1++;
            }else if(num==possNum2){
                count2++;
            }else if(count1==0){
                possNum1 = num;
                count1 = 1;
            }else if(count2==0){
                possNum2 = num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        for(int num : arr){
            if(num == possNum1){
                count1++;
            }
            if(num == possNum2){
                count2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if(possNum1<possNum2){
            if (count1 > arr.length / 3) {
                ans.add(possNum1);
            }
            if (count2 > arr.length / 3){
                ans.add(possNum2);
            }
        }else{
            if (count2 > arr.length / 3){
                ans.add(possNum2);
            }
            if (count1 > arr.length / 3) {
                ans.add(possNum1);
            }
        }

        return ans;
    }
}
