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
        
        List<ListNode> list = new ArrayList();
        for(ListNode head: lists) {
            while(head != null) {
                list.add(head);
                head = head.next;
            }
        }
        
        if(list.size() == 0) {
            return null;
        }
        Collections.sort(list, (a,b) -> a.val - b.val);
        
        ListNode head = list.get(0);
        ListNode temp = head;
        
        for(int i = 1; i<list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        
        return head;
    }
}