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
    private int answer;
    public int maxDepth(TreeNode root) {
        answer = 0;
        maxDepthHelper(root, 0);
        
        return answer;
    }
    
    private void maxDepthHelper(TreeNode root, int depth) {
        if(root == null) {
            answer = Math.max(answer, depth);
            return;
        }
        
        maxDepthHelper(root.left, depth+1);
        maxDepthHelper(root.right, depth+1);
    } 
}