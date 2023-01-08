class Edge implements Comparable<Edge> {
    int p1, p2, dist;
    Edge(int i, int j, int d) {
        p1 = i;
        p2 = j;
        dist = d;
    }
    
    public int compareTo(Edge e) {
        return this.dist - e.dist;
    }
}
class UnionFind {
    int[] parent, rank;
    int n;
    
    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    int find(int u) {
        if(parent[u] == u) return u;
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        if(parU == parV) return;
        
        if(rank[parU] < rank[parV]) {
            parent[parU] = parent[parV];
        }
        else {
            parent[parV] = parent[parU];
            if(rank[parU] == rank[parV]) {
                rank[parU]++;
            }
        }
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList();
        int n = points.length;
        
        for(int i = 0; i<n; i++) {
            int[] p1 = points[i];
            int x1 = p1[0], y1 = p1[1];
            for(int j = i+1; j<n; j++) {
                int[] p2 = points[j];
                int x2 = p2[0], y2 = p2[1];
                
                int dist = Math.abs(x2-x1) + Math.abs(y2-y1);
                Edge e = new Edge(i, j, dist);
                edges.add(e);
            }
        }
        
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        
        int sum = 0;
        for(Edge e: edges) {
            int u = e.p1;
            int v = e.p2;
            int d = e.dist;
            
            int parU = uf.find(u);
            int parV = uf.find(v);
            
            if(parU == parV) continue;
            
            uf.union(u, v);
            sum += d;
        }
        
        return sum;
    }
}