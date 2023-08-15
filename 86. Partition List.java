//86. Partition List

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head;
        ListNode p1 = head;
        while (p1 != null) {
            if (head.val >= x && head.next.val < x) {
                ListNode temp = head;
                head = head.next;
                temp.next = head.next == null ? null : head.next;
                head.next = temp;
                ans = head;
            }
            while (head.next.next != null) {
                if (head.next.next.val < x && head.next.val >= x) {
                    ListNode temp = head.next;
                    head.next = head.next.next;
                    temp.next = head.next.next;
                    head.next.next = temp;
                }
                head = head.next;
            }
            if (head.val >= x && head.next.val < x) {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
                head.next = temp;
            }
            head = ans;
            p1 = p1.next;
        }
        return ans;
    }
}