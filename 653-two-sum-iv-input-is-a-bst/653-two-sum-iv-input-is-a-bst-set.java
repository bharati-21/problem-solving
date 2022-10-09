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
    HashSet<Integer> seen;
    public boolean findTarget(TreeNode root, int k) {
        seen = new HashSet();
        return dfs(root, k);
    }
    
    private boolean dfs(TreeNode root, int target) {
        if(root == null) {
            return false;
        }
        
        if(seen.contains(target - root.val)) {
            return true;
        }
        seen.add(root.val);
        return dfs(root.left, target) || dfs(root.right, target);
    } 
    
}
