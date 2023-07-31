//206. Reverse Linked List

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode behind = null, ahead = null;

        while (curr != null) {
            ahead = curr.next;
            curr.next = behind;
            behind = curr;
            curr = ahead;
        }
        return behind;

        /*
         * List<Integer> l=new ArrayList<Integer>();
         * while(head!=null){
         * l.add(head.val);
         * head=head.next;
         * }
         * head=new ListNode();
         * ListNode ans=head;
         * for(int i=l.size()-1;i>=0;i--){
         * ListNode temp=new ListNode(l.get(i));
         * head.next=temp;
         * head=head.next;
         * }
         * return ans.next;
         */
    }
}