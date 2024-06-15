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
    public ListNode oddEvenList(ListNode head) {

        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode dummy1 = first;
        ListNode dummy2 = second;
        ListNode curr = head;

        while(curr != null) {

            ListNode next = curr.next;
            dummy1.next = curr;
            dummy1 = dummy1.next;

            dummy2.next = next;
            dummy2 = dummy2.next;

            if(next != null && next.next != null) {
                curr = next.next;
            } else {
                break;
            }
      
        }

        dummy1.next = second.next;

        return first.next;
    }
}