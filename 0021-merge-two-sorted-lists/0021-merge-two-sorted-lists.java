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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {        
        if(list1 == null && list2 == null) {
            return null;
        }
        
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        }
        else {
            ListNode nextNode = list1;
            list1 = list2;
            list1.next = mergeTwoLists(nextNode, list2.next);
        }
        
        return list1;
    }
}