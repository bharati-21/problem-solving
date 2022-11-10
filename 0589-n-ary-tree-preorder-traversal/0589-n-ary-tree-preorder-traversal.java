/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        Stack<Node> stack = new Stack();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            if(top == null) {
                continue;
            }
            
            list.add(top.val);
            
            int numChildren = top.children.size();
            for(int i = numChildren-1; i>=0; i--) {
                stack.push(top.children.get(i));
            }
        }
        
        return list;
    }
}