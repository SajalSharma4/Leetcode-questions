//51. N-Queens

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1: 
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        int[] back = new int[n];
        int[] backup = new int[2 * n - 1];
        int[] backdown = new int[2 * n - 1];
        Arrays.fill(back, 0);
        Arrays.fill(backup, 0);
        Arrays.fill(backdown, 0);
        getAns(0, board, back, backup, backdown, ans, n);
        return ans;
    }

    public static void getAns(int col, String[][] board, int[] back, int[] backup, int[] backdown,
            List<List<String>> ans, int n) {
        if (col == n) {
            List<String> a = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String b = "";
                for (int j = 0; j < n; j++) {
                    b += board[i][j];
                }
                a.add(b);
            }
            ans.add(new ArrayList<>(a));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (back[i] == 0 && backup[n - 1 + i - col] == 0 && backdown[i + col] == 0) {
                board[i][col] = "Q";
                back[i] = 1;
                backup[n - 1 + i - col] = 1;
                backdown[i + col] = 1;
                getAns(col + 1, board, back, backup, backdown, ans, n);
                board[i][col] = ".";
                back[i] = 0;
                backup[n - 1 + i - col] = 0;
                backdown[i + col] = 0;
            }
        }
    }
}