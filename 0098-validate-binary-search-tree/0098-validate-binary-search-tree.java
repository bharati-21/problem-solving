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
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        long max = Integer.MAX_VALUE + 1l;
        long min = Integer.MIN_VALUE - 1l;
                
        return isValidBSTHelper(root, min, max);
    }
    
    private boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        
        int val = root.val;
        if(val <= min || val >= max) {
            return false;
        } 
        
        return isValidBSTHelper(root.left, min, val) && isValidBSTHelper(root.right, val, max);
    }
}