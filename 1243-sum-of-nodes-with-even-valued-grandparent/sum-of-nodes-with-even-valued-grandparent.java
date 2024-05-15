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
        
        Queue<TreeNode> queue = new LinkedList();
        int sum = 0;
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i=0; i<size; i++) {

                TreeNode temp = queue.poll();

                if(temp.val % 2 == 0) {

                    if(temp.left != null) {

                        if(temp.left.left != null) {
                            sum += temp.left.left.val;
                        }

                        if(temp.left.right != null) {
                            sum += temp.left.right.val;
                        }
                       
                    }

                    if(temp.right != null) {

                        if(temp.right.left != null) {
                            sum += temp.right.left.val;
                        }

                        if(temp.right.right != null) {
                            sum += temp.right.right.val;
                        }
                        
                    }
                   
                }
                
                    if(temp.left != null){
                        queue.add(temp.left);
                    }

                    if(temp.right != null) {
                        queue.add(temp.right);
                    }

            }
        }
      return sum;  
    }
}