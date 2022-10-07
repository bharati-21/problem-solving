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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode newLeftNode = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = newLeftNode; 
        return root;
    }
}

/**
- At every node in the tree, we invert the node's left with the node's right
- TC: O(n) => We are visiting every node
- SC: O(n) => In the worst case (skewed tree), calls to n nodes are in the stack
*/