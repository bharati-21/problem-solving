class Union {
    int n;
    int[] parent;
    int[] rank;
    
    Union(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int u) {
        if(u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    
    public void union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        
        if(parU != parV) {
            if(rank[u] >= rank[v]) {
                parent[parV] = parU;
                rank[u]++;
            }
            else {
                parent[parU] = parV;
                rank[v]++;
            }
        }
    }
    
    public boolean areConnected(int u, int v){
        return find(u) == find(v);
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Union union = new Union(n);
        
        
        for(int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            union.union(u, v);
        }
                
        return union.areConnected(source, destination);
    }
}
