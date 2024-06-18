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
    public int maxLevelSum(TreeNode root) {
        
        int max = Integer.MIN_VALUE;
        int res = 0, level=0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;
            level++;
            for(int i=0; i<size; i++) {

                TreeNode temp = queue.poll();
                sum += temp.val;

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }


                if(sum > max) {
                    max = sum;
                    res = level;
                }
        }

      return res;  
    }
}