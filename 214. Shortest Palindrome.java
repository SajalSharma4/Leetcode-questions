//214. Shortest Palindrome

/*
You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"
 */

class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = s.length();
        while (true) {
            i = 0;
            for (int k = j - 1; k >= 0; k--) {
                if (s.charAt(k) == s.charAt(i))
                    i++;
            }
            if (i == j)
                break;
            j = i;
        }
        ans.append(s.substring(j, s.length())).reverse().append(s.substring(0, j)).append(s.substring(j, s.length()));
        return ans.toString();
    }
}