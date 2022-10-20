class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int islands = 0;
        
        for(int r = 0; r<m; r++) {
            for(int c = 0; c<n; c++) {
                int cell = grid[r][c];
                boolean seen = visited[r][c];
                if(cell == '1' && !seen) {
                    dfs(r, c, m, n, grid, visited);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(int r, int c, int m, int n, char[][] grid, boolean[][] visited) {
        if(r >= m || c >= n || r < 0 || c < 0 || grid[r][c] != '1' || visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        for(int[] dir: directions) {
            int nextRow = r + dir[0];
            int nextCol = c + dir[1];
            
            dfs(nextRow, nextCol, m, n, grid, visited);
        }
    }
}