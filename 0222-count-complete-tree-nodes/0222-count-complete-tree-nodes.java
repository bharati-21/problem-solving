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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int count = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            count++;
            TreeNode parent = queue.poll();
            
            if(parent.left != null) {
                queue.add(parent.left);
            }
            
            if(parent.right != null) {
                queue.add(parent.right);
            }
        }
        
        return count;
    }
}