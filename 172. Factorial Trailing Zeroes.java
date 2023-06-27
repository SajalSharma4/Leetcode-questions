//172. Factorial Trailing Zeroes

/*
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */

class Solution {
    public int trailingZeroes(int n) {
        if (n == 0 || n < 5) {
            return 0;
        }

        int x = 0;
        while (true) {
            x += n / 5;
            n = n / 5;
            if (n < 5) {
                break;
            }
        }

        return x;
    }
}