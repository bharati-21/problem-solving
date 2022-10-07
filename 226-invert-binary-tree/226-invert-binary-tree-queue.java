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
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if(parent == null) {
                continue;
            }
            TreeNode leftNode = parent.left;
            parent.left = parent.right;
            parent.right = leftNode;
            
            queue.add(parent.left);
            queue.add(parent.right);
        }
        
        return root;
    }
}
