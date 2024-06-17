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

    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) {
            return sum;
        }
       helper(root, targetSum);
       pathSum(root.left, targetSum);
       pathSum(root.right, targetSum);

     return sum;  
    }

    public void helper(TreeNode root, int target) {

        if(root == null) {
            return;
        }

        if(target - root.val <= -1000000000 
            || target-root.val >= 1000000000) {
            return;
        }

        if(target - root.val == 0) {
            sum += 1;
        }

        helper(root.left, target - root.val);
        helper(root.right, target - root.val);

    }
}