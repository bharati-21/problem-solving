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
        return hasPathSumHelper(root, targetSum);
    }
    
    private boolean hasPathSumHelper(TreeNode root, int target) {
        int curr = root.val;
        if(root.left == null && root.right == null) {
            if(target - curr == 0) return true;
            return false;
        }
        
        boolean ans = false;
        
        if(root.left != null) ans = ans || hasPathSumHelper(root.left, target - curr);
        if(root.right != null) ans = ans || hasPathSumHelper(root.right, target - curr);
        
        return ans;
    }
}