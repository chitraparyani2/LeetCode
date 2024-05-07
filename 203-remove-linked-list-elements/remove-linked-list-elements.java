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
    public ListNode removeElements(ListNode head, int val) {
        
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            ListNode curr = head;
            ListNode prev = preHead;

            while(curr != null) {

                if(curr.val != val) {
                    prev = prev.next;
                } else {
                    prev.next = curr.next;
                }
                    curr = curr.next;
            }

        return preHead.next;    
    }
}