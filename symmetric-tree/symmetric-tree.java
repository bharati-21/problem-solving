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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            
            if(node1 == null && node2 == null) {
                continue;
            }
            if(node1 == null || node2 == null) return false;
            
            if(node1.val != node2.val) return false;
            
            queue.add(node1.left);
            queue.add(node2.right);
            
            queue.add(node2.left);
            queue.add(node1.right);
        }
        
        return true;
    }
}