class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) {
            return new int[0];
        }
        
        int[] edge = new int[2];
        int n = edges.length;
        
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        
        // Initially parent and rank both are 1
        for(int i = 1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            
            if(!union(u, v, rank, parent)) {
                return new int[] { u, v };
            }
            
        }
        
        return edge;
    }
    
    private boolean union(int u, int v, int[] rank, int[] parent) {
        int parU = find(u, parent);
        int parV = find(v, parent);
        
        if(parU == parV) {
            return false;
        }
        
        if(rank[parU] > rank[parV]) {
            parent[parV] = parU;
            rank[parU]++;
        }
        else {
            parent[parU] = parV;
            rank[parV]++;
        }
        
        return true;
    }
    
    private int find(int n, int[] parent) {
        int p = parent[n];
        while(p != parent[p]) {
            // path compression
            // E.g. parent[4] = 3, and parent[3] = 2
            // so we make parent[4] = parent[parent[4]]
            // parent[4] = parent[3]
            // parent[4] = 2
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        
        return p;
    } 
}

/*
rank: 1->1, 2->2, 3->1, 4->1, 5->1
parent: 1->1, 2->w, 3->3, 4->4, 5->5

union(1,2)
rank: 1->2, 2->1, 3->1, 4->1, 5->1
parent: 1->1, 2->1, 3->3, 4->4, 5->5

union(2,3)
par(2) = 1, par(3) = 1
rank(2) = 1, rank(3) = 1
rank: 1->2, 2->2, 3->1, 4->1, 5->1
parent: 1->1, 2->1, 3->2, 4->4, 5->5

union(3,4)
par(3) = 2, par(4) = 4
rank(3) = 1, rank(4) = 1
rank: 1->2, 2->2, 3->2, 4->1, 5->1
parent: 1->1, 2->1, 3->2, 4->3, 5->5


union(1,4)
par(1) = 1, par(4) = 3
*/