class Solution {
    public int makeConnected(int n, int[][] connections) {
        // to connect n components we need at least n-1 edges
        if(connections.length < (n-1)) return -1;    
        
        Set<Integer> visited = new HashSet();
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i<n; i++) adj.add(new ArrayList());
        
        for(int[] connection: connections) {
            int u = connection[0], v = connection[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int components = 0;
        for(int i = 0; i<n; i++) {
            if(!visited.contains(i)) {
                traverseNodes(i, adj, visited);
                components++;
            }
        }
        
        return components-1;
    }
    
    private void traverseNodes(int node, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        
        for(int next: adj.get(node)) {
            if(!visited.contains(next)) {
                traverseNodes(next, adj, visited);
            }
        }
    }
}