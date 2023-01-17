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
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        
        int n = preorder.length;
        for(int i = 0; i<n; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, 0, n-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int pIndex, int left, int right) {
        if(left > right) return null;
        
        int rootVal = preorder[pIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = map.get(rootVal);
        
        int preLeft = pIndex+1;
        int preRight = pIndex + inIndex - left + 1;
        
        root.left = buildTreeHelper(preorder, preLeft, left, inIndex-1);
        root.right = buildTreeHelper(preorder, preRight, inIndex+1, right);
        
        return root;
    }
}