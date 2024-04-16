/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        helper(queue);
      return sum;  
    }

    public void helper(Queue<TreeNode> queue) {

        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if(node != null && node.val % 2 == 0) {
                
                if(node.left != null) {
                    if(node.left.left != null) {
                        sum += node.left.left.val;
                    }

                    if(node.left.right != null) {
                        sum += node.left.right.val;
                    }
                       
                }

                if(node.right != null) {
                    if(node.right.left != null) {
                        sum += node.right.left.val;
                    }

                    if(node.right.right != null) {
                        sum += node.right.right.val;
                    }

                    
                }
            }   
                if(node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
        }
    }
}