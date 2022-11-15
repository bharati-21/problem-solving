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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        TreeNode left = root.left, right = root.right;
        
        int leftHeight = 1 + getLeftHeight(left);
        int rightHeight = 1 + getRightHeight(right);
        
        if(leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        
        return 1 + countNodes(right) + countNodes(left);
    }
    
    private int getLeftHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + getLeftHeight(root.left);
    }
    
    private int getRightHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + getRightHeight(root.right);
    }
}