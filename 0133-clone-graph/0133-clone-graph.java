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
        Node head = new Node(node.val, new ArrayList());
        
        // This maps created nodes
        Map<Node, Node> map = new HashMap();
        map.put(node, head);
        
        Set<Node> seen = new HashSet();
//         Queue<Node> queue = new LinkedList();
        
//         queue.add(node);
//         queue.add(head);
//         seen.add(node);
        
//         while(!queue.isEmpty()) {
//             // This is the node for old graph
//             Node prev = queue.poll();
//             // this represents the old graph node
//             Node curr = queue.poll();
            
//             if(prev == null) {
//                 continue;
//             }
            
//             for(Node n: prev.neighbors) {
//                 int val = n.val;
//                 if(!seen.contains(n)) {
//                     Node newNode;
//                     if(map.containsKey(val)) {
//                         newNode = map.get(val);
//                     }
//                     else {
//                         newNode = new Node(val, new ArrayList());
//                         map.put(val, newNode);
//                     }
                    
//                     seen.add(n);
//                     queue.add(n);
//                     queue.add(newNode);
//                 }
                
//                 if(!curr.neighbors.contains(map.get(val))) {
//                     curr.neighbors.add(map.get(val));
//                 }
//             }
//         }
        
        // return head;
        
        return dfs(node, map, seen);
    }
    
    
    private Node dfs(Node node, Map<Node, Node> map, Set<Node> visited) {
        if(node == null) {
            return null;
        }
        
        
        visited.add(node);
         
        Node curr;
        if(!map.containsKey(node)) {
            curr = new Node(node.val, new ArrayList());
            map.put(node, curr);
        }
        else {
            curr = map.get(node);
        }
        
        // iterate over neighbors
        for(Node neighbor: node.neighbors) {
            Node newNeighbor;
            if(!map.containsKey(neighbor)) {
                newNeighbor = new Node(neighbor.val, new ArrayList());
                map.put(neighbor, newNeighbor);
            }
            else {
                newNeighbor = map.get(neighbor);
            }
            
            if(!curr.neighbors.contains(newNeighbor)) {
                curr.neighbors.add(newNeighbor);
            }
            
            if(!visited.contains(neighbor)) {
                dfs(neighbor, map, visited);
            }
        }
        
        return curr;
    }
}