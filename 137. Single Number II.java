//137. Single Number II
/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int x = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                ans = nums[i];
                x = 1;
                break;
            }
        }
        if (x == 0) {
            ans = nums[nums.length - 1];
        }
        return ans;
    }
}