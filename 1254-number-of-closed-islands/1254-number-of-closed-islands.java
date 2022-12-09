class Solution {
    private int rows, cols;
    private boolean[][] visited;
    private int[][] direction = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        int islands = 0;
        
        for(int row = 0; row < rows; row++) {
            if(!visited[row][0] && grid[row][0] == 0) {
                // travserse adjacent nodes and mark visited
                traverseIsland(row, 0, grid);
            }
            
            if(!visited[row][cols-1] && grid[row][cols-1] == 0) {
                // travserse adjacent nodes and mark visited
                traverseIsland(row, cols-1, grid);
            }
        }
        
        for(int col = 0; col < cols; col++) {
            if(!visited[0][col] && grid[0][col] == 0) {
                // travserse adjacent nodes and mark visited
                traverseIsland(0, col, grid);
            }
            
            if(!visited[rows-1][col] && grid[rows-1][col] == 0) {
                // travserse adjacent nodes and mark visited
                traverseIsland(rows-1, col, grid);
            }
        }
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(!visited[row][col] && grid[row][col] == 0) {
                    islands++;
                    traverseIsland(row, col, grid);
                }
            }
        }
        
        return islands;
    }
        
    private void traverseIsland(int row, int col, int[][] grid) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || 
           grid[row][col] == 1 || visited[row][col]) return;
        
        visited[row][col] = true;
        
        for(int[] dir: direction) {
            traverseIsland(row + dir[0], col + dir[1], grid);
        }
    }
}

// Any zero connected with the border is not an island
// Any zero connected with any other zeros in borser is not an island