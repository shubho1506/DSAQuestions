package POTD;

//You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with
// horizontal and vertical sides such that all the 1's in grid lie inside these rectangles.
//Return the minimum possible sum of the area of these rectangles.
//Note that the rectangles are allowed to touch.
//Example 1:
//Input: grid = [[1,0,1],[1,1,1]]
//Output: 5
//Explanation:
//The 1's at (0, 0) and (1, 0) are covered by a rectangle of area 2.
//The 1's at (0, 2) and (1, 2) are covered by a rectangle of area 2.
//The 1 at (1, 1) is covered by a rectangle of area 1.
//Example 2:
//Input: grid = [[1,0,1,0],[0,1,0,1]]
//Output: 5
//Explanation:
//The 1's at (0, 0) and (0, 2) are covered by a rectangle of area 3.
//The 1 at (1, 1) is covered by a rectangle of area 1.
//The 1 at (1, 3) is covered by a rectangle of area 1.

public class FindTheMinimumAreaToCoverAllOnesII {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1,0},{0,1,0,1}};
        System.out.println(minimumSum(grid));
    }

    private static int boundingBoxArea(int[][] grid, int u, int d, int l, int r){
        int minRow = grid.length;
        int maxRow = -1;
        int minCol = grid[0].length;
        int maxCol = -1;
        for(int i=u;i<=d;i++){
            for(int j=l;j<=r; j++){
                if(grid[i][j] == 1){
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        // If no 1's is found, return "infinite" cost so this partition is invalid
        if(maxRow == -1){
            return Integer.MAX_VALUE/3;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int best = n * m;
        //Case 1: L- shaped partitions
        for (int row = 0; row + 1 < n; row++) {
            for (int col = 0; col + 1 < m; col++) {
                //Top + Bottom - left + Bottom - right
                int area1 = boundingBoxArea(grid, 0, row, 0, m - 1) + boundingBoxArea(grid, row + 1, n - 1, 0, col)
                        + boundingBoxArea(grid, row + 1, n - 1, col + 1, m - 1);

                //top-left + top-right + bottom
                int area2 = boundingBoxArea(grid, 0, row, 0, col) + boundingBoxArea(grid, 0, row, col + 1, m - 1)
                        + boundingBoxArea(grid, row + 1, n - 1, 0, m - 1);

                best = Math.min(best, Math.min(area1, area2));
            }
        }

        //Case 2 : Three horizontal strips

        for (int r1 = 0; r1 + 2 < n; r1++) {
            for (int r2 = r1 + 1; r2 + 1 < n; r2++) {
                int area = boundingBoxArea(grid, 0, r1, 0, m - 1) + boundingBoxArea(grid, r1 + 1, r2, 0, m - 1)
                        + boundingBoxArea(grid, r2 + 1, n - 1, 0, m - 1);
                best = Math.min(best, area);
            }
        }
        return best;
    }

    private static int[][] rotate90(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = grid[i][j];
            }
        }
        return rotated;
    }

    public static int minimumSum(int[][] grid) {
        int[][] rotated = rotate90(grid);
        return Math.min(solve(grid), solve(rotated));
    }
}
