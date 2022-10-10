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
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        
        s1.push(root);
        while(!s1.isEmpty()) {
            TreeNode top = s1.pop();
            if(top == null) {
                continue;
            }
            s2.push(top);
            s1.push(top.left);
            s1.push(top.right);
        }
        
        List<Integer> list = new ArrayList();
        while(!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        
        return list;
    }
}