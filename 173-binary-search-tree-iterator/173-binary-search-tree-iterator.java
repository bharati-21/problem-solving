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
    private Stack<TreeNode> inorder;
    
    private void insertAllLeft(TreeNode node) {
        while(node != null) {
            inorder.push(node);
            node = node.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        inorder = new Stack();
        insertAllLeft(root);
    }
    
    public int next() {
        TreeNode top = inorder.pop();
        if(top.right != null) {
            TreeNode node = top.right;
            insertAllLeft(node);
        }
        
        return top.val;
    }
    
    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */