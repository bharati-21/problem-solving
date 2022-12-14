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
class Node {
    TreeNode node;
    int row, col;
    Node(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        
        int leftMostCol = 0, rightMostCol = 0;
        if(root == null) return traversal;
        
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root, 0, 0));
        Map<Integer, List<Node>> map = new TreeMap();
        
        
        // O(N) => all nodes visited
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            TreeNode node = front.node;
            int row = front.row, col = front.col;
            if(col < leftMostCol) {
                leftMostCol = col;
            }
            else if(col > rightMostCol) {
                rightMostCol = col;
            }
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList());
            }
            map.get(col).add(front);
            
            if(node.left != null) {
                Node child = new Node(node.left, row+1, col-1);
                queue.add(child);
            }
            if(node.right != null) {
                Node child = new Node(node.right, row+1, col+1);
                queue.add(child);
            }
        }
        
        // If there are k cols and each col has j values then (k * jlog j)
        int index = 0;
        for(int column: map.keySet()) {
            traversal.add(new ArrayList());
            List<Node> list = map.get(column);
            Collections.sort(list, (a,b) -> 
                             (a.col == b.col) ? 
                                (a.row == b.row) ? a.node.val - b.node.val 
                                : a.row - b.row 
                             : a.col - b.col
            );
            
            for(Node node: map.get(column)) {
                traversal.get(index).add(node.node.val);
            }
            index++;
        }
        
        return traversal;
    }
}
