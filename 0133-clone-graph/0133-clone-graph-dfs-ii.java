/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) {
            return node;
        }
        
        // This maps created nodes
        Map<Node, Node> map = new HashMap();
                
        return dfs(node, map);
    }
    
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if(node == null) {
            return null;
        }
        
        if(map.containsKey(node)) {
            return map.get(node);
        }
        
        Node curr = new Node(node.val, new ArrayList());
        map.put(node, curr);
        
        // iterate over neighbors
        for(Node neighbor: node.neighbors) {
            Node newNeighbor = dfs(neighbor, map);
            curr.neighbors.add(newNeighbor);
        }
        
        return curr;
    }
}
