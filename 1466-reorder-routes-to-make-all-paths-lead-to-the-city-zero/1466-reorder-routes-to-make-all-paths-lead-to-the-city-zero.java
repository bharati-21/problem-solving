class Solution {
    public int minReorder(int n, int[][] connections) {
        if(connections == null || connections.length == 0) {
            return 0;
        }
        
        List<List<Integer>> adj = getAdjacency(connections, n);
        boolean[] visited = new boolean[n];
        return dfs(adj, 0, visited);
    }
    
    private List<List<Integer>> getAdjacency(int[][] connections, int n) {
        List<List<Integer>> adj = new ArrayList(n);
        
        for(int i = 0; i<n; i++) {
            adj.add(i, new ArrayList());
        }
        
        for(int[] edge: connections) {
            int u = edge[0], v = edge[1];
            // an edge from u to v
            adj.get(u).add(-v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    
    
    private int dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        int ans = 0;
        
        for(int child: adj.get(node)) {
            int absChild = Math.abs(child);
            if(visited[absChild]) continue;
            
            ans += dfs(adj, absChild, visited) + ((child < 0) ? 1 : 0);
        }
        
        return ans;
    }
}