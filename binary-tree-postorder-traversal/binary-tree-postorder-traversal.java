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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();
        
        List<Integer> list = new ArrayList();
        
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack();
        stack1.push(root);
        
        while(!stack1.isEmpty()) {
            TreeNode top = stack1.pop();
            if(top.left != null) stack1.push(top.left);
            if(top.right != null) stack1.push(top.right);
            
            stack2.push(top);
        }
        
        while(!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        
        return list;
    }
}