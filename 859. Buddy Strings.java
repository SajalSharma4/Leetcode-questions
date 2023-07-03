// 859. Buddy Strings
/*
Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

Example 3:
Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 */

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> x = new HashSet<Character>();
            for (int i = 0; i < s.length(); i++) {
                if (x.contains(s.charAt(i))) {
                    return true;
                } else {
                    x.add(s.charAt(i));
                }
            }
        }
        int index1 = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index1 = i;
                count++;
                break;
            }
        }

        int index2 = 0;
        for (int i = index1 + 1; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index2 = i;
                count++;
            }
        }

        if (count != 2 || s.charAt(index1) != goal.charAt(index2) || s.charAt(index2) != goal.charAt(index1)) {
            return false;
        }
        return true;
    }
}