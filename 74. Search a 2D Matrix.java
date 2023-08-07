//74. Search a 2D Matrix

/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == target) {
                    return true;
                }
            }
            return false;
        }
        int x = -1;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i - 1][0] <= target && matrix[i][0] > target) {
                x = i - 1;
            } else if (matrix[i - 1][0] < target && matrix[i][0] >= target) {
                x = i;
            }
        }
        if (x == -1 && matrix[matrix.length - 1][0] < target) {
            x = matrix.length - 1;
        }
        if (x == -1) {
            return false;
        }
        for (int i = 0; i < matrix[x].length; i++) {
            if (matrix[x][i] == target) {
                return true;
            }
        }
        return false;
    }
}