class UnionFind {
    int n, components;
    int[] parent, rank;
    int extraCables;
    
    UnionFind(int n) {
        this.n = n;
        components = n;
        parent = new int[n];
        rank = new int[n];
        extraCables = 0;
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    int find(int u) {
        if(parent[u] == u) {
            return u;
        }
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u), parV = find(v);
        
        if(parU == parV) {
            extraCables++;
            return;
        }
        
        if(rank[parU] < rank[parV]) {
            parent[parU] = parV;
        }
        else {
            parent[parV] = parU;
            if(rank[parV] == rank[parU]) {
                rank[parU]++;
            }
        }
        components--;
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] connection: connections) {
            int u = connection[0], v = connection[1];
            
            uf.union(u, v);
        }
        
        int components = uf.components;
        int extraCables = uf.extraCables;
                
        if((components-1) <= extraCables) {
            return components-1;
        }
        
        return -1;
    }
}

// if I have n disconnected components
// to connect them I need at least n-1 cables to make them connected