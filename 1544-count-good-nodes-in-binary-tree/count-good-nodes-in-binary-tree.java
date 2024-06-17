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
    public int goodNodes(TreeNode root) {
        
        helper(root, Integer.MIN_VALUE);

        return sum;
    }

    public void helper(TreeNode root, Integer st) {

        if(root == null){
            return;
        }
        
        if(root.val >= st) {
            sum += 1;
        }

        helper(root.left, Math.max(root.val, st));
        helper(root.right, Math.max(root.val, st));
    }
}