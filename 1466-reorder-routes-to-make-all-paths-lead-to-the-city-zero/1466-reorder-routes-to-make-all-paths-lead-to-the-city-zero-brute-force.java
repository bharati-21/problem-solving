class Solution {
    public int minReorder(int n, int[][] connections) {
        if(connections == null || connections.length == 0) {
            return 0;
        }
        
        List<List<Integer>> adj = getAdjacency(connections, n);
        Map<Integer, List<Integer>> map = getNodeToNeighbors(connections);
        boolean[] visited = new boolean[n];
        return dfs(adj, map, 0, visited);
    }
    
    private List<List<Integer>> getAdjacency(int[][] connections, int n) {
        List<List<Integer>> adj = new ArrayList(n);
        
        for(int i = 0; i<n; i++) {
            adj.add(i, new ArrayList());
        }
        
        for(int[] edge: connections) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    
    private Map<Integer, List<Integer>> getNodeToNeighbors(int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge: connections) {
            int u = edge[0], v = edge[1];
            if(!map.containsKey(u)) {
                map.put(u, new ArrayList());
            }
            
            map.get(u).add(v);
        }
        
        return map;
    }
    
    private int dfs(List<List<Integer>> adj, Map<Integer, List<Integer>> map, int node, boolean[] visited) {
        if(visited[node]) {
            return 0;
        }       
        
        visited[node] = true;
        int ans = 0;
        
        for(int child: adj.get(node)) {
            if(!visited[child] && (!map.containsKey(child) || !map.get(child).contains(node))) {
                ans++;
            }
            ans += dfs(adj, map, child, visited);
        }
        
        return ans;
    }
}
