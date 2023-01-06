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
    public int rob(TreeNode root) {
        int[] values = robHelper(root);
        
        return Math.max(values[0], values[1]);
    }
    
    private int[] robHelper(TreeNode root) {
        if(root == null) {
            return new int[]{ 0, 0 };
        }
        
        int[] leftTree = robHelper(root.left);
        int[] rightTree = robHelper(root.right);
        
        int includeRoot = root.val + leftTree[1] + rightTree[1];
        int notIncludeRoot = Math.max(leftTree[0], leftTree[1]) + Math.max(rightTree[0], rightTree[1]);
        
        return new int[] { includeRoot, notIncludeRoot };
    }
}