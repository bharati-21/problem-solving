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
    List<Integer> traversal;
    public boolean findTarget(TreeNode root, int k) {
        traversal = new ArrayList();
        inorderTraversal(root);
        
        int left = 0, right = traversal.size()-1;
        while(left < right) {
            int sum = traversal.get(left) + traversal.get(right);
            if(sum == k) {
                return true;
            }
            if(sum > k) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return false;
    }
    
    private void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        traversal.add(root.val);
        inorderTraversal(root.right);
    }
}