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
        ListNode prev = head;

        while(fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode list = reverseNode(slow);

        return compare(head, list);
    }

    public ListNode reverseNode(ListNode head) {

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

    public boolean compare(ListNode list1, ListNode list2) {

        while(list1 != null && list2 != null) {

            if(list1.val != list2.val) {
                return false;
            }

            list1 = list1.next;
            list2 = list2.next;
        }
      return true;  
    }
}