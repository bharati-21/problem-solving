class UnionFind {
    int[] root, rank;
    int provinces;
    
    UnionFind(int size) {
        this.root = new int[size+1];  
        this.rank = new int[size+1];
        this.provinces = size;
        
        for(int i = 1; i<root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    private int find(int node) {
        if(root[node] == node) {
            return node;
        }
        
        return root[node] = find(root[node]);
    }
    
    public void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        
        if(rootA != rootB) {
            if(rank[rootA] > rank[rootB]){
                root[rootB] = rootA;
            }
            else if(rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            }
            else {
                root[rootB] = rootA;
                rank[rootA] += 1;
            }
            provinces--;
        }
    }
    
    public boolean isConnected(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        
        return rootA == rootB;
    }
    
    public int getProvinces() {
        return provinces;
    }
    
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i+1, j+1);
                }
            }
        }
        
        
        return uf.getProvinces();
    }
}
// 1 -> 4
// 2 -> 3
// 2, 