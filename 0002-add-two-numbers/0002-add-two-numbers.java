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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
        }
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummyHead = new ListNode(-1);
        ListNode ptr = dummyHead;
        int carry = 0;


        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            ptr = ptr.next;
        }
        
        ptr.next = (l1 != null) ? l1 : l2;
        
        
        if(carry != 0) {
            ListNode prev = ptr;
            ptr = ptr.next;
            while(ptr != null) {
                prev = ptr;
                int sum = ptr.val + carry;
                carry = sum / 10;
                ptr.val = sum % 10;
                ptr = ptr.next;
            }

            if(carry != 0) prev.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
