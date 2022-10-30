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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1,l2) -> l1.val - l2.val);
        
        for(ListNode h: lists) {
            if(h != null) {
                pq.add(h);
            }
        }
        
        while(!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
            ListNode newHead = temp.next;
            if(newHead != null) {
                pq.add(newHead);
            }
        }
        
        temp.next = null;
        return head.next;
    }
}
