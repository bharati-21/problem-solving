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
    TreeNode prev;
    int minDist = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        minDiffInBSTHelper(root);
        
        return minDist;
    }
    
    private void minDiffInBSTHelper(TreeNode root) {
        if(root == null) return;
        
        minDiffInBSTHelper(root.left);
        
        if(prev != null) {
            minDist = Math.min(minDist, root.val - prev.val);
        }
        
        prev = root;
        
        minDiffInBSTHelper(root.right);
    }
}