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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        if(root == null) {
            return traversal;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = root;
        
        while(parent != null || !stack.isEmpty()) {
            while(parent != null) {
                stack.push(parent);
                parent = parent.left;
            }
            parent = stack.pop();
            traversal.add(parent.val);
            parent = parent.right;
        }
        
        return traversal;
    }
}
