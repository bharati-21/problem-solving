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
    public void flatten(TreeNode root) {
        if(root == null) return;
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        // leaf node
        if(root.right == null && root.left == null) {
            return root;
        }
        
        TreeNode temp = root.right;
        TreeNode leftLeaf = flattenHelper(root.left);
        TreeNode rightLeaf = flattenHelper(root.right);
        
        if(root.left != null) {
            root.right = root.left;
            if(leftLeaf != null) leftLeaf.right = temp;
            root.left = null;
        }
        
        return rightLeaf == null ? leftLeaf : rightLeaf;
    }
}