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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        } 
        
        diameterOfBinaryTreeHelper(root);
        
        return maxDiameter;
    }
    
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        // either include the root node with the left diameter and the right diameter. Keep. this as max diameter (root + left + right)
        // pass the max(left, right) 
        int leftDiameter = diameterOfBinaryTreeHelper(root.left);
        int rightDiameter = diameterOfBinaryTreeHelper(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
