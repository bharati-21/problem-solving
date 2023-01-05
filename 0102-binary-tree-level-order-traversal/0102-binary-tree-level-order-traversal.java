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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesByLevel = new ArrayList();
        
        if(root == null) return nodesByLevel;
        
        Queue<TreeNode> nodes = new LinkedList();
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> levelNodes = new ArrayList();
            
            for(int i = 0; i<size; i++) {
                TreeNode curr = nodes.poll();
                levelNodes.add(curr.val);
                if(curr.left != null) {
                    nodes.add(curr.left);
                }
                if(curr.right != null) {
                    nodes.add(curr.right);
                }
            }
            nodesByLevel.add(levelNodes);
        }
        
        return nodesByLevel;
    }
}