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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedHelper(root, 0);
        return balanced;
    }
    
    private int isBalancedHelper(TreeNode root, int height) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = 1 + isBalancedHelper(root.left, height);
        int rightHeight = 1 + isBalancedHelper(root.right, height);
        if(balanced && Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        return  Math.max(leftHeight, rightHeight);
    }
}