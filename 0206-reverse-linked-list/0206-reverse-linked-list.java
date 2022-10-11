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
    // 1, null
    // 2, 1
        // nextNode = 5 -> 4 -> 3 -> 2
    // 3, 2
        // nextNode = 5 -> 4 -> 3
        // nextNode.next = 2
        // return 5 -> 4 -> 3 -> 2
    // 4, 3
        // nextNode = 5 -> 4
        // nextNode.next = 3;
        // return 5 -> 4 -> 3
    // 5, 4
        // 5.next = 4
        // return 5 -> 4
    // null, 5 (return null)
    private ListNode reverseListHelper(ListNode head, ListNode prev) {
        if(head == null) {
            return null;
        }
        ListNode nextNode = reverseListHelper(head.next, head);
        head.next = prev;
        return nextNode == null ? head : nextNode;
    }
}