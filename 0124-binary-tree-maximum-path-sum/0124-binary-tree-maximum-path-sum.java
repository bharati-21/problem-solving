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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        
        maxPathSumHelper(root);
        return maxSum;
    }
    
    
    private int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxPathSumHelper(root.left);
        if(left < 0) left = 0;
        int right = maxPathSumHelper(root.right);
        if(right < 0) right = 0;
        
        int curr = root.val;
        
        // include left, right subtrees and the root
        maxSum = Math.max(left + right + curr, maxSum);
        
        return Math.max(left, right) + root.val;
    }
}