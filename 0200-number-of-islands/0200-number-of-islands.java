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
                    bfs(r, c, grid, visited);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void bfs(int row, int col, char[][] grid, boolean[][] visited) {
        Queue<int []> queue = new LinkedList();
        
        visited[row][col] = true;
        queue.add(new int[] {row, col});
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0];
            int currCol = cell[1];
            
            for(int[] dir: directions) {
                int nextRow = dir[0] + currRow;
                int nextCol = dir[1] + currCol;
                
                if(!isValidCell(nextRow, nextCol, grid, visited)) {
                    continue;
                }
                
                visited[nextRow][nextCol] = true;
                queue.add(new int[] { nextRow, nextCol });
            }
        }
    }
    
    private boolean isValidCell(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0' || visited[row][col]) {
            return false;
        }
        
        return true;
    }
}