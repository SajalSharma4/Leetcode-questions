//213. House Robber II

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [1,2,3]
Output: 3
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] t1 = new int[nums.length - 1];
        int[] t2 = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            t1[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            t2[i - 1] = nums[i];
        }
        int a1 = getVal(t1);
        int a2 = getVal(t2);

        return Math.max(a1, a2);
    }

    public static int getVal(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if (i > 1) {
                take += prev2;
            }
            int nott = 0 + prev;
            prev2 = prev;
            prev = Math.max(take, nott);
        }
        return prev;
    }
}