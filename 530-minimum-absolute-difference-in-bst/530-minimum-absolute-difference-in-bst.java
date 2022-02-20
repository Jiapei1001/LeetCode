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
    Integer prev = null;
    int res = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        
        // process current node
        if (prev != null) {
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        
        inorder(root.right);
    }
}