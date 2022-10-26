/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size-1; i++) {
                Node first = queue.poll();
                Node second = queue.peek();
                first.next = second;
                
                if(first.left != null) {
                    queue.add(first.left);
                }
                if(first.right != null) {
                    queue.add(first.right);
                }
            }
            Node last = queue.poll();
            last.next = null;
            if(last.left != null) {
                queue.add(last.left);
            }
            if(last.right != null) {
                queue.add(last.right);
            }
        }
        
        return root;
    }
}