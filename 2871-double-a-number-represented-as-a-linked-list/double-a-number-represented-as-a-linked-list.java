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
    public ListNode doubleIt(ListNode head) {
        
        ListNode reversed = reverseList(head);

        ListNode doubleList = makeItDouble(reversed);

        ListNode res = reverseList(doubleList);

      return res;  
    }

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
      return prev;  
    }

    public ListNode makeItDouble(ListNode head) {

        ListNode curr = head;
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        while(curr != null) {

            int val = (curr.val * 2) + carry;

            dummy.next = new ListNode(val%10);
            carry = val/10;

            dummy = dummy.next;
            curr = curr.next;
        }

        if(carry > 0) {
            dummy.next = new ListNode(carry);
        }
      return res.next;  
    }
}