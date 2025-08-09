package GreedyProblems.Hard;

//There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//You are giving candies to these children subjected to the following requirements:
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//Return the minimum number of candies you need to have to distribute the candies to the children.

//Example 1:
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

//Example 2:
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        System.out.println(candyBrute(ratings));
        System.out.println(candyLessOpt(ratings));
        System.out.println(candySlopeOptimized(ratings));
    }

    public static int candyBrute(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        int candies = 0;
        left[0]=1;
        right[ratings.length-1]=1;
        for(int i=1;i<left.length;i++){
            if(ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }
        for(int i=0;i<ratings.length;i++){
            candies += Math.max(left[i],right[i]);
        }
        return candies;
    }

    public static int candyLessOpt(int[] ratings){
        int[] left = new int[ratings.length];
        left[0]=1;
        for(int i=1;i<left.length;i++){
            if(ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        int current = 1;
        int right = 1;
        int candies = Math.max(1,left[left.length-1]);
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                current = right+1;
            }else{
                current = 1;
            }
            right = current;
            candies += Math.max(left[i],current);
        }
        return candies;
    }

    //weird approach
    public static int candySlopeOptimized(int[] ratings){
        int n = ratings.length;
        int i=1;
        int sum = 1;
        while (i<n){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while (i<n && ratings[i]>ratings[i-1]){
                peak++;
                i++;
                sum+=peak;
            }
            int down = 0;
            while (i<n && ratings[i]<ratings[i-1]){
                down++;
                i++;
                sum+=down;
            }
            down++;
            if(down>peak){
                sum+=down-peak;
            }
        }
        return sum;
    }
}
