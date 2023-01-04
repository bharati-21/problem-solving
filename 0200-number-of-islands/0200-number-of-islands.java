class UnionFind {
    int[] parent, rank;
    int m, n;
    int count;
    
    UnionFind(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        parent = new int[m*n];
        Arrays.fill(parent, -1);
        rank = new int[m*n];
        count = 0;
                
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    int id = (i * n) + j;
                    parent[id] = id;
                    rank[id] = 1;
                }
            }
        }
    }
    
    int find(int u) {
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        
        if(parU == parV) return;
        
        if(rank[parU] >= rank[parV]) {
            parent[parV] = parU;
            
            if(rank[parU] == rank[parV]) {
                rank[parU]++;
            }
        }
        else {
            parent[parU] = parV;
        }
        count--;
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        UnionFind uf = new UnionFind(grid);
        
        int[][] dir = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    
                    int cell = (row * cols) + col;
                    
                    for(int[] d: dir) {
                        int nextRow = d[0] + row;
                        int nextCol = d[1] + col;
                        
                        if(nextRow >= rows || nextRow < 0 || nextCol >= cols || nextCol < 0 ||
                          grid[nextRow][nextCol] == '0') {
                            continue;
                        }
                        
                        int nextCell = (nextRow * cols) + nextCol;
                        uf.union(cell, nextCell);
                    }
                }
            }
        }
        
        return uf.count;
    }
}