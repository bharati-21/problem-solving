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
    private int numGoodNodes;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        
        numGoodNodes = 0;
        
        goodNodesHelper(root, root.val);
        
        return numGoodNodes;
    }
    
    private void goodNodesHelper(TreeNode root, int maxValSoFar) {
        if(root == null) return;
        
        if(root.val >= maxValSoFar) {
            numGoodNodes++;
        }
        
        goodNodesHelper(root.left, Math.max(maxValSoFar, root.val));
        goodNodesHelper(root.right, Math.max(maxValSoFar, root.val));
    }
}