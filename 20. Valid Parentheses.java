//20. Valid Parentheses

//Beats 90% on leetcode

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(]"
Output: false
 */

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> x = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                if (!x.isEmpty()) {
                    char y = x.pop();
                    if (y != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!x.isEmpty()) {
                    char y = x.pop();
                    if (y != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (!x.isEmpty()) {
                    char y = x.pop();
                    if (y != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                x.push(s.charAt(i));
            }
        }
        if (!x.isEmpty()) {
            return false;
        }
        return true;
    }
}