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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrder = new ArrayList();
        if(root == null) return zigzagOrder;
        
        Queue<TreeNode> nodes = new LinkedList();
        boolean leftToRight = false;
        
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> level = new ArrayList();
            while(size-- > 0) {
                TreeNode curr = nodes.poll();
                
                if(leftToRight) level.add(0, curr.val);
                else level.add(curr.val);
                
                if(curr.left != null) {
                    nodes.add(curr.left);
                }
                if(curr.right != null) {
                    nodes.add(curr.right);
                }
                
            }
            
            zigzagOrder.add(level);
            leftToRight = !leftToRight;
        }
        
        
        return zigzagOrder;
    }
}