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
        
        while(true) {
            boolean toBreak = true;
            int min = Integer.MAX_VALUE;
            int min_index = 0;
            // If all the lists have been traversed and all are 
            // pointing to the end, then break this outer while loop
            for(int i = 0; i<lists.length; i++) {
                ListNode curr = lists[i];
                if(curr != null) {
                    if(curr.val < min) {
                        min = curr.val;
                        min_index = i;
                    }
                    toBreak = false;
                }
            }
            if(toBreak) break;
            
            temp.next = lists[min_index];
            temp = temp.next;
            lists[min_index] = lists[min_index].next;
        }
        
        temp.next = null;
        return head.next;
    }
}