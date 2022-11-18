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
        if(root == null) return new ArrayList();
        
        List<Integer> list = new ArrayList();
        
        Stack<TreeNode> stack = new Stack();
        TreeNode parent = root;
        stack.push(parent);
        
        while(!stack.isEmpty()) {
            while(parent != null) {
                if(parent.left != null) stack.add(parent.left);
                
                parent = parent.left;
            }
            
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                stack.push(curr.right);
                parent = curr.right;
            }
            list.add(curr.val);
        }
        
        return list;
    }
}