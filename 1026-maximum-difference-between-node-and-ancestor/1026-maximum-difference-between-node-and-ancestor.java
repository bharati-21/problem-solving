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
    private int maxDifference = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffHelper(root, root.val, root.val);
        
        return maxDifference;
    }
    
    private void maxAncestorDiffHelper(TreeNode root, int max, int min) {
        if(root == null) return;
        
        int val = root.val;
        int differenceOne = Math.abs(val - min);
        int differenceTwo = Math.abs(val - max);
        maxDifference = Math.max(maxDifference, Math.max(differenceOne, differenceTwo));
                
        max = Math.max(val, max);
        min = Math.min(val, min);
        
        maxAncestorDiffHelper(root.left, max, min);
        maxAncestorDiffHelper(root.right, max, min);
    }
}