class Union {
    int n;
    int[] parent;
    
    Union(int n) {
        this.n = n;
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
            parent[parV] = parU;
        }
    }
    
    public boolean areConnected(int u, int v){
        return find(u) == find(v);
    }
}

// [0,0,2]
// [0,0,1]

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

/*
10
[[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]
5
9

[0,1,2,3,4,5,6,7,8,9]
union(4,3)
parent[3] == 3
parent[3] = 4
[0,1,2,1,1,5,6,7,8,9]

union(1,4)
parent[3] == 4 && parent[4] == 4
parent[3] = 1
parent[4] = 1
[0,1,2,4,4,5,6,7,8,9]

union(4,8)
parent[8] == 8
parent[8] = parent[4](1)
[0,1,2,1,1,5,6,7,1,9]

union(1,7)
parent[7] == 7
parent[7] = 1
[0,1,2,1,1,5,6,1,1,9]

union(6,4)
parent[4] = 1
parent[4] == 1
parent[1] == 1
parent[3] == 1
parent[7] == 1
parent[8] == 1
parent[4] = parent[1] = parent[3] = parent[7] = parent[8] = 6
[0,6,2,6,6,5,6,6,6,9]

union(4,2)
parent[2] = 2
parent[2] = 6
[0,6,6,6,6,5,6,6,6,9]

union(4,7) 
parent[4] == parent[7]

union(4,0)
parent[0] = parent[4]
[6,6,6,6,6,5,6,6,6,9]

union(0,9)
parent[9] == 9
parent[9] = 6
[0,0,0,0,0,5,0,0,0,0]

union(5,4)
parent[5] = 5
parent[4] = 0
[5,5,5,5,5,5,5,5,5,5]

*/