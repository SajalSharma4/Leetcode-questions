//125. Valid Palindrome

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 */

class Solution {
    // Check if it is lowercase or uppercase
    public boolean isAlpha(char a) {
        if (a < 123 && a > 96) {
            return true;
        }
        return false;
    }

    // checks if both the characters are same or not, even if they are of different
    // cases
    public boolean myFunc(char a, char b) {
        if ((Character.isDigit(a) && Character.isDigit(b))) {
            if (a == b) {
                return true;
            }
        } else {
            if (isAlpha(a) && isAlpha(b) && a == b) {
                return true;
            } else if (isAlpha(a) && !isAlpha(b) && a == Character.toLowerCase(b)) {
                return true;
            } else if (!isAlpha(a) && isAlpha(b) && Character.toLowerCase(a) == b) {
                return true;
            } else {
                if (a == b) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if we shall consider this an element or not
    public boolean isOk(char a) {
        if ((a <= 'z' && a >= 'a') || (a <= 'Z' && a >= 'A') || (Character.isDigit(a))) {
            return true;
        }
        return false;
    }

    // Checks if the string is palindrome or not
    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!isOk(a)) {
                i++;
            } else if (!isOk(b)) {
                j--;
            } else {
                if (!myFunc(a, b)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}