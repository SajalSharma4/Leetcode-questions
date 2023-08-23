//2. Add Two Numbers

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            ans.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            ans.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            ans = ans.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            ans.next = new ListNode(val % 10);
            carry = val / 10;
            l2 = l2.next;
            ans = ans.next;
        }
        while (carry != 0) {
            ans.next = new ListNode(carry % 10);
            carry = carry / 10;
            ans = ans.next;
        }
        return p.next;
    }
}