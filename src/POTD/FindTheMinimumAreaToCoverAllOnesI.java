package POTD;

//You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area,
// such that all the 1's in grid lie inside this rectangle.
//Return the minimum possible area of the rectangle.
//Example 1:
//Input: grid = [[0,1,0],[1,0,1]]
//Output: 6
//Explanation:
//The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.
//Example 2:
//Input: grid = [[1,0],[0,0]]
//Output: 1
//Explanation:
//The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.

public class FindTheMinimumAreaToCoverAllOnesI {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{1,0,1}};
        System.out.println(minimumArea(grid));
    }

    public static int minimumArea(int[][] grid) {
        int startRow = grid.length;
        int endRow = -1;
        int startCol = grid[0].length;
        int endCol = -1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    startRow=Math.min(startRow,i);
                    endRow=Math.max(endRow,i);
                    startCol=Math.min(startCol,j);
                    endCol=Math.max(endCol,j);
                }
            }
        }
        return (endRow-startRow+1)*(endCol-startCol+1);
    }
}
