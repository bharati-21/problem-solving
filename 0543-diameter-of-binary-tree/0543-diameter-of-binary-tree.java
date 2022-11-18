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
    private int maxPath;
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath = 0;
        diameterOfBinaryTreeHelper(root);
        
        return maxPath;
    }
    
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) return 0;
        
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);
        
        maxPath = Math.max(left + right, maxPath);
        
        return 1 + Math.max(left, right);
    }
}