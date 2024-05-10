/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode currA = headA;
        ListNode currB = headB;

        int lenA=0, lenB=0;

        while(currA != null) {
            lenA++;
            currA = currA.next;
        }

        while(currB != null) {
            lenB++;
            currB = currB.next;
        }

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
      return headA;  
    }
}