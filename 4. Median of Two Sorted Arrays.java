//4. Median of Two Sorted Arrays

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double sum = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        for (int i = 0; i < m; i++) {
            ans[i] = nums1[i];
        }
        for (int i = m; i < m + n; i++) {
            ans[i] = nums2[i - m];
        }
        Arrays.sort(ans);
        if ((m + n) % 2 == 0) {
            double val = ans[(m + n) / 2] + ans[((m + n) / 2) - 1];
            return val / 2;
        }
        return (double) ans[(m + n) / 2];

    }
}