//67. Add Binary

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
class Solution {
    public String addBinary(String a, String b) {
        int x = a.length() - 1;
        int y = b.length() - 1;
        String ans = "";
        int car = 0;
        while (x > y) {
            b = "0" + b;
            y++;
        }
        while (x < y) {
            a = "0" + a;
            x++;
        }
        while (x >= 0 && y >= 0) {
            char u = a.charAt(x);
            char v = b.charAt(y);
            if (car == 0) {
                if (u == '1' && v == '1') {
                    ans += "0";
                    car = 1;

                } else if (u == '0' && v == '0') {
                    ans += "0";
                } else {
                    ans += "1";
                }
            } else {
                if (u == '1' && v == '1') {
                    ans += "1";
                    car = 1;
                } else if (u == '0' && v == '0') {
                    ans += "1";
                    car = 0;
                } else {
                    ans += "0";
                    car = 1;
                }
            }
            x--;
            y--;
        }
        if (car == 1) {
            ans += "1";
        }
        String fin = "";
        for (int i = ans.length() - 1; i >= 0; i--) {
            fin += String.valueOf(ans.charAt(i));
        }
        return fin;
    }
}