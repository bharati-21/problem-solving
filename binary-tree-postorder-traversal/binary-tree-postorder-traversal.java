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
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode top = stack.peek();
                TreeNode rightNode = top.right;
                
                if(rightNode != null) {
                    curr = rightNode;
                }
                else {
                    top = stack.pop();
                    list.add(top.val);
                    
                    while(!stack.isEmpty() && stack.peek().right == top) {
                        top = stack.pop();
                        list.add(top.val);
                    }
                }
            }
            
        }
        
        return list;
    }
}