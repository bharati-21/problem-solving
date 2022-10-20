class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        
        int maxArea = 0;
        
        for(int r = 0; r<m; r++) {
            for(int c = 0; c<n; c++) {
                int cell = grid[r][c];
                boolean isSeen = seen[r][c];
                
                if(cell == 1 && !isSeen) {
                    int area = dfs(r, c, m, n, grid, seen);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int row, int col, int m, int n, int[][] grid, boolean[][] seen) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || seen[row][col]) {
            return 0;
        }
        
        seen[row][col] = true;
        int[][] directions = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0,1}
        };
        
        int area = 1;

        for(int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];             
            area += dfs(nextRow, nextCol, m, n, grid, seen);
        }
            
            
        return area;
    } 

}