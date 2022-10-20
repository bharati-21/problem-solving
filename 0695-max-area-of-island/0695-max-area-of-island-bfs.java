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
                    int area = bfs(r, c, m, n, grid, seen);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int bfs(int row, int col, int m, int n, int[][] grid, boolean[][] seen) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] { row, col });
        
        seen[row][col] = true;
        int[][] directions = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0,1}
        };
        
        int area = 0;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            area++;
            
            for(int[] dir: directions) {
                int nextRow = cell[0] + dir[0];
                int nextCol = cell[1] + dir[1];
                
                if(!isValidCell(nextRow, nextCol, m, n, grid, seen)) {
                    continue;
                }
                
                queue.add(new int[] { nextRow, nextCol });
                seen[nextRow][nextCol] = true;
            }
        }
            
            
        return area;
    } 
    
    private boolean isValidCell(int row, int col, int m, int n, int[][] grid, boolean[][] seen) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || seen[row][col]) {
            return false;
        }
        
        return true;
    }
}
