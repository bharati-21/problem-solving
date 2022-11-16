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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        int nextTarget = targetSum - root.val;
        if(root.left == null && root.right == null) {
            return nextTarget == 0;
        }
        return hasPathSum(root.left, nextTarget) || hasPathSum(root.right, nextTarget);
    }
}