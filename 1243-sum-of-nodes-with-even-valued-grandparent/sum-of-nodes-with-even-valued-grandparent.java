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
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int sum = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i=0; i<size; i++) {

                TreeNode node = queue.poll();

                if(node.val%2 == 0) {

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

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
      return sum;  
    }
}