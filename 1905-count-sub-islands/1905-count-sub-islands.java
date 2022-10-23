class Solution {
    int[][] directions = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}    
    };
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if(grid2 == null || grid2.length == 0 || grid1 == null || grid1.length == 0) {
            return 0;
        }
        
        int m = grid1.length;
        int n = grid1[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int subIslands = 0;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                int cell = grid2[row][col];
                boolean seen = visited[row][col];
                
                if(cell == 1 && !seen) {
                    boolean ans = isSubIsland(row, col, m, n, grid2, visited, grid1);
                    if(ans) {
                        subIslands++;
                    }
                }
            }
        }
        
        return subIslands;
    }
    
    private boolean isSubIsland(int row, int col, int m, int n, int[][] grid, boolean[][] visited, int[][] grid2) {
        visited[row][col] = true;
        
        boolean subIsland = true;
        if(grid2[row][col] == 0) {
            // Since there's a clear mismatch
            subIsland = false;
        }
        
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            
            if(!valid(nRow, nCol, m, n, grid, visited)) {
                continue;
            }
            
            boolean isNeighborSubIsland = isSubIsland(nRow, nCol, m, n, grid, visited, grid2);
            if(!isNeighborSubIsland) {
                subIsland = false;
            }
        }
        
        
        return subIsland;
    }
    
    private boolean valid(int row, int col, int m, int n, int[][] grid, boolean[][] visited) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return false;
        }
        
        return true;
    }
}