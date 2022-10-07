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
        List<Integer> traversal = new ArrayList<>();
        if(root == null) {
            return traversal;
        }
        List<Integer> leftTraversal = inorderTraversal(root.left);
        if(!leftTraversal.isEmpty()) {
            traversal.addAll(leftTraversal);
        }
        traversal.add(root.val);
        List<Integer> rightTraversal = inorderTraversal(root.right);
        if(!rightTraversal.isEmpty()) {
            traversal.addAll(rightTraversal);
        }
        
        return traversal;
    }
}

/**
  TC: O(n) => Traversing through every node in the tree once
  SC: O(n) => Implicit recursion stack space. In the worst case if the tree is skewed, then call to all nodes will be in the stack at the same time
*/
