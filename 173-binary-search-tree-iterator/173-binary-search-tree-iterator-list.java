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
class BSTIterator {
    private List<Integer> inorderTraversal;
  
    public BSTIterator(TreeNode root) {
        inorderTraversal = new ArrayList();
        insertAll(root);
    }
    
    public int next() {
        int nextVal = inorderTraversal.get(0);
        inorderTraversal.remove(0);
        return nextVal;
    }
    
    public boolean hasNext() {
        return !inorderTraversal.isEmpty();
    }
    
    private void insertAll(TreeNode root) {
        if(root == null) {
            return;
        }
        insertAll(root.left);
        inorderTraversal.add(root.val);
        insertAll(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
