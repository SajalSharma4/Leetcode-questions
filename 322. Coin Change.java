//322. Coin Change

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
/*
 * class Solution {
 * public int coinChange(int[] coins, int amount) {
 * int[] ans={Integer.MAX_VALUE};
 * Arrays.sort(coins);
 * getAns(coins.length-1,coins,amount,ans,0);
 * if(ans[0]==Integer.MAX_VALUE){
 * ans[0]=-1;
 * }
 * return ans[0];
 * }
 * 
 * public static void getAns(int ind, int[] coins, int target, int[] ans,int
 * count){
 * if(ind<0 || target<0){
 * return;
 * }
 * if(target==0){
 * ans[0]=Math.min(ans[0],count);
 * return;
 * }
 * getAns(ind,coins, target-coins[ind],ans,count+1 );
 * getAns(ind-1,coins,target,ans,count);
 * 
 * }
 * }
 */