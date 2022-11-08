class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 0) {
            return false;
        }
        
        List<List<Integer>> adj = getAdjacencyList(edges, n);
        return dfs(adj, source, destination, new HashSet());
    }
    
    // adj = [[1,2],[0,2],[0,1]]
    // visited = [0]
    // 
    
    // TC: O(n + m)
    // SC: O(n + m)
    private boolean dfs(List<List<Integer>> adj, int source, int dest, Set<Integer> visited) {
        visited.add(source);
        if(source == dest) {
            return true;
        }
        
        for(int node: adj.get(source)) {
            if(!visited.contains(node)) {
                if(dfs(adj, node, dest, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private List<List<Integer>> getAdjacencyList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(i, new ArrayList());
        }
        
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}