//63. Unique Paths II

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example-
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int dp[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
/*
 * // A solution using recursion
 * class Solution {
 * public int uniquePathsWithObstacles(int[][] obstacleGrid) {
 * int[] arr={0};
 * getAns(obstacleGrid, 0,0, arr);
 * return arr[0];
 * }
 * public static void getAns(int[][] arr, int r, int c, int[] count){
 * if(r<arr.length && c<arr[0].length){
 * if(arr[r][c]==1){
 * return;
 * }
 * }
 * if(r==arr.length-1 && c==arr[0].length-1 && arr[r][c]==0){
 * count[0]++;
 * return;
 * }
 * if(r<arr.length){
 * getAns(arr, r+1,c,count);
 * }
 * if(c<arr[0].length){
 * getAns(arr,r,c+1,count);
 * }
 * }
 * }
 */