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
    public ListNode removeNodes(ListNode head) {
        
        Stack<Integer> stack = new Stack();

        ListNode curr = head;

        while(curr != null) {

            while(!stack.isEmpty() && curr.val > stack.peek()) {
                    stack.pop();
                }
            stack.push(curr.val);
            curr = curr.next;
        }

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        while(!stack.isEmpty()) {

            dummy.next = new ListNode(stack.pop());
            dummy = dummy.next;
        }

        return reverseList(res.next);
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

}