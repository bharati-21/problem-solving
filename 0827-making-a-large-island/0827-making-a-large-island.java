class UnionFind {
    int[] parent, rank, size;
    int m, n;
    int components;
    
    UnionFind(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        parent = new int[m*n];
        rank = new int[m*n];
        size = new int[m*n];
        components = 0;
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) components++;
                
                int id = (i * n) + j;
                parent[id] = id;
                rank[id] = 0;
                size[id] = 1;
            }
        }
    }
    
    int find(int u) {
        if(parent[u] == u) return u;
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u), parV = find(v);
        
        if(parU == parV) return;
        
        if(rank[parU] > rank[parV]) {
            parent[parV] = parU;
            size[parU] += size[parV];
        }
        else if(rank[parU] < rank[parV]) {
            parent[parU] = parV;
            size[parV] += size[parU];
        }
        else {
            parent[parV] = parU;
            size[parU] += size[parV];
            rank[parU]++;
        }
    }
    
    int getMaxSize() {
        int maxSize = 0;
        for(int s: size) {
            maxSize = Math.max(s, maxSize);
        }
        
        return maxSize;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        UnionFind uf = new UnionFind(grid);
        
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    int cell = (row * cols) + col;
                    for(int[] dir: directions) {
                        int nextRow = row + dir[0], nextCol = col + dir[1];
                        
                        if(isInvalid(nextRow, nextCol, grid)) {
                            continue;
                        }
                        int nextCell = (nextRow * cols) + nextCol;
                        
                        uf.union(cell, nextCell);
                    }
                }
            }
        }
        
        int maxSize = uf.getMaxSize();
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {
                    Set<Integer> neighbors = new HashSet();
                    int cell = (row * cols) + col;
                    
                    for(int[] dir: directions) {
                        int nextRow = row + dir[0], nextCol = col + dir[1];
                        
                        if(isInvalid(nextRow, nextCol, grid)) {
                            continue;
                        }
                        
                        int nextCell = (nextRow * cols) + nextCol;
                        int parNextCol = uf.find(nextCell);
                        
                        neighbors.add(parNextCol);
                    }
                    
                    int size = 1;
                    for(int par: neighbors) {
                        size += uf.size[par];
                    }
                    
                    maxSize = Math.max(size, maxSize);
                }
            }
        } 
        
        return maxSize;
    }
    
    private boolean isInvalid(int row, int col, int[][] grid) {
        return (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
            grid[row][col] == 0);
    }
}
