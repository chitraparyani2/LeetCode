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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        while(fast != null && fast.next != null) {
            
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        return merge(list1, list2);

    }

    public ListNode merge(ListNode list1, ListNode list2) {

     if(list1 == null) {
        return list2;
     } else if(list2 == null) {
        return list1;
     } else if(list1.val <= list2.val) {
        list1.next = merge(list1.next, list2);
        return list1;
     } else {
        list2.next = merge(list1, list2.next);
        return list2;
     }
    }
}