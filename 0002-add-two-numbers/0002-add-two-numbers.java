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


        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;

            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            ptr = ptr.next;
        }

        return dummyHead.next;
    }
}

