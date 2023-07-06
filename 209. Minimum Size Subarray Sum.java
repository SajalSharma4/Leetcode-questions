//209. Minimum Size Subarray Sum
/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                count = Math.min(count, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (count == Integer.MAX_VALUE) {
            return 0;
        }
        return count;
    }
}