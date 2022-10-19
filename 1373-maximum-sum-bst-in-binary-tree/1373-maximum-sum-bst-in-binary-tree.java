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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maxSum;
    }
    
    // val, min, max, isValid
    private int[] maxSumBSTHelper(TreeNode root) {
        if(root == null) {
            return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int[] left = maxSumBSTHelper(root.left);
        int[] right = maxSumBSTHelper(root.right);
        
        int val = root.val;

        
        // This means that the subtree rooted at root is not a valid BST
        // If the current val is less than the max value of the left sub tree
        // or the current val is greater than the min value of the right sub tree
        if(left == null || val <= left[2] || right == null || val >= right[1]) {
            return null;
        }

        // else if this root is a valid BST 
        int sum = left[0] + right[0] + val;
        maxSum = Math.max(sum, maxSum);
        
        int max = Math.max(val, right[2]);
        int min = Math.min(val, left[1]);
        
        return new int[] {sum, min, max};
    }
}
