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
    List<Integer> rightNodes;
    public List<Integer> rightSideView(TreeNode root) {
        rightNodes = new ArrayList<Integer>();
               
        rightSideViewHelper(root, 0);
        return rightNodes;
    }
    
    private void rightSideViewHelper(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        
        if(rightNodes.size() == level) {
            rightNodes.add(root.val);
        }
        
        rightSideViewHelper(root.right, level+1);
        rightSideViewHelper(root.left, level+1);
    }
}