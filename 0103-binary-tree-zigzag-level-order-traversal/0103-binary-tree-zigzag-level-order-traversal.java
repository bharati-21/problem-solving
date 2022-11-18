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
        List<List<Integer>> answer = new ArrayList();
        
        if(root == null) return answer;
        
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);    
    
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            
            while(size-- > 0) {
                TreeNode parent = queue.poll();
                if(parent.left != null) queue.add(parent.left);
                if(parent.right != null) queue.add(parent.right);
                
                if(leftToRight) {
                    list.add(parent.val);
                }
                else {
                    list.add(0, parent.val);
                }
            }
            
            leftToRight = !leftToRight;
            answer.add(list);
        }
        
        return answer;
    }
}