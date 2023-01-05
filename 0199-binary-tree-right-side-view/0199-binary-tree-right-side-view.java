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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<Integer>();
        
        if(root == null) return rightNodes;
        
        Queue<TreeNode> nodes = new LinkedList();
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = nodes.poll();
                if(i == 0) {
                    rightNodes.add(curr.val);
                }
                
                if(curr.right != null) {
                    nodes.add(curr.right);
                }
                if(curr.left != null) {
                    nodes.add(curr.left);
                }
            }
        }
        
        return rightNodes;
    }
}