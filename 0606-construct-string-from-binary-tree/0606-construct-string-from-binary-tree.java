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
    private StringBuilder str;
    public String tree2str(TreeNode root) {
        str = new StringBuilder();
        if(root == null) return "";
        
        helper(root);
        
        return str.toString();
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        
        
        str.append(root.val + "");
        if(root.right == null && root.left == null) return;
        
        str.append("(");
        helper(root.left);
        str.append(")");
        
        if(root.right != null) {
            str.append("(");
            helper(root.right);
            str.append(")");
        }
    }
}

/*
1(2(4))
*/