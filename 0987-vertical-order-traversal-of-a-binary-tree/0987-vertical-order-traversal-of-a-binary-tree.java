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
        
        if(root == null) return traversal;
        
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root, 0, 0));
        Map<Integer, PriorityQueue<Node>> map = new TreeMap();
        
        
        // O(N) => all nodes visited
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            TreeNode node = front.node;
            
            int row = front.row, col = front.col;
            
            if(!map.containsKey(col)) {
                map.put(col, new PriorityQueue(new CustomComparator()));
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
            
            PriorityQueue<Node> pq = map.get(column);
            while(!pq.isEmpty()) {
                Node node = pq.poll();
                traversal.get(index).add(node.node.val);
            }
            index++;
        }
        
        return traversal;
    }
}

class CustomComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        
        if(a.col == b.col) {
            if(a.row == b.row) {
                return a.node.val - b.node.val;
            }
            return a.row - b.row;
        }
        
        return a.col - b.col;
    }
}