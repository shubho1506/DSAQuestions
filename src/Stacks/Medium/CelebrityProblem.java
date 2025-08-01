package Stacks.Medium;

//A celebrity is a person who is known to all but does not know anyone at a party.
// A party is being organized by some people. A square matrix mat[][] (n*n) is used to represent people at the party
// such that if an element of row i and column j is set to 1 it means ith person knows jth person.
// You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
//Note: Follow 0-based indexing.
//Examples:
//Input: mat[][] = [[1, 1, 0], [0, 1, 0], [0, 1, 1]]
//Output: 1
//Explanation: 0th and 2nd person both know 1st person. Therefore, 1 is the celebrity person.

//Input: mat[][] = [[1, 1], [1, 1]]
//Output: -1
//Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.

//Input: mat[][] = [[1]]
//Output: 0

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0},{0, 1, 0},{0, 1, 1}};
        System.out.println(celebrity(matrix));
    }

    public static int celebrity(int M[][]) {
        int celebrity = 0;
        for(int i = 1; i< M.length ; i++){
            if(M[celebrity][i]==1){
                celebrity = i ;
            }
        }

        for(int i = 0 ; i<M.length ; i++){
            if(i==celebrity){
                continue;
            }
            if(M[celebrity][i]==1 || M[i][celebrity]==0){
                return -1;
            }
        }
        return celebrity;
    }
}
