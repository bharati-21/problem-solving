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
    HashMap<Integer, Integer> map;
    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap();
        return bfs(root, 0, k);
    }
    
    private boolean bfs(TreeNode root, int num, int target) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                continue;
            }
            map.put(node.val, num);
            int diff = target - node.val;
            if(map.containsKey(diff) && map.get(diff) != num) {
                return true;
            }
            num++;
            queue.add(node.left);
            queue.add(node.right);
        }
        
        return false;
    }
}