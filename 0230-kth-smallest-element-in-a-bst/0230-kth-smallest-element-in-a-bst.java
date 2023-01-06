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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> values = new ArrayList();
        
        Stack<TreeNode> nodes = new Stack();
        
        TreeNode ptr = root;
        while(ptr != null || !nodes.isEmpty()) {
            while(ptr != null) {
                nodes.add(ptr);
                ptr = ptr.left;
            }
            
            ptr = nodes.pop();
            k--;
            if(k == 0) break;
            
            ptr = ptr.right;
        }
        
        return ptr.val;
    }
}