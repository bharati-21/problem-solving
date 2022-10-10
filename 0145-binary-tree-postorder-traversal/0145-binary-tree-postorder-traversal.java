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
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        
        TreeNode parent = root;
        while(!stack.isEmpty() || parent != null) {
            while(parent != null) {
                stack.add(parent);
                parent = parent.left;
            }
            
            TreeNode curr = stack.peek();
            TreeNode temp = curr.right;
            if(temp != null) {
                parent = temp;
                continue;
            }
            
            curr = stack.pop();
            list.add(curr.val);
            while(!stack.isEmpty() && stack.peek().right == curr) {
                curr = stack.pop();
                list.add(curr.val);
            }
        }
        
        return list;
    }
}