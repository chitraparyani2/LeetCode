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
    public int pairSum(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
      //  ListNode prev = slow;

        while(fast != null && fast.next != null) {
         //   prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

       // prev.next = null;
        ListNode reversed = reverseList(slow);

        int max = compare(head, reversed);

      return max;  
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

    public int compare(ListNode head1, ListNode head2) {

            int sum = 0, max = 0;

        while(head1 != null && head2 != null) {

            sum = head1.val + head2.val;
            max = Math.max(max, sum);
            
            head1 = head1.next;
            head2 = head2.next;
        }
      return max;  
    }
}