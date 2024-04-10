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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        while(fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode res = reverseList(slow);

        return compare(head, res);

    }

    public ListNode reverseList(ListNode node) {

        ListNode prev = null;
        ListNode curr = node;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
      return prev;  
    }

    public boolean compare(ListNode list1, ListNode list2) {

        
        while(list1 != null && list2 != null) {


            if(list1.val == list2.val) {
                list1 = list1.next;
                list2 = list2.next;
            } else {
                return false;
            }
        }

      return true;  
    }
}