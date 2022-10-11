/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }
    
    private ListNode reverseListHelper(ListNode head, ListNode prev) {
        if(head == null) {
            return null;
        }
        ListNode nextNode = reverseListHelper(head.next, head);
        head.next = prev;
        return nextNode == null ? head : nextNode;
    }
}