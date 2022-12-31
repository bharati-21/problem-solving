class Solution {
    private int rows, cols;
    private int nonObstacleCells = 0;
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
        int[][] gridCopy = new int[rows][cols];
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                gridCopy[row][col] = grid[row][col];
                if(grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
                else if(grid[row][col] == 2) {
                    endRow = row;
                    endCol = col;
                }
                
                if(grid[row][col] == 0) {
                    nonObstacleCells++;
                }
            }
        }
        
        return visitAllPaths(gridCopy, startRow, startCol, endRow, endCol);
    }
    
    private int visitAllPaths(int[][] grid, int row, int col, int endRow, int endCol) {
        if(row == endRow && col == endCol) {
            // boolean allNonObstaclesVisited = checkIfAllNonObstaclesVisited(grid);
            
            // if(!allNonObstaclesVisited) {
            //     return 0;
            // }
            if(nonObstacleCells == 0) return 1;
            return 0;
        }
        
        // mark as visited
        int val = grid[row][col];
        grid[row][col] = 3;
        
        if(val == 0) {
            nonObstacleCells--;
        }
        
        int paths = 0;
        int prevRow = row-1, nextRow = row+1, prevCol = col-1, nextCol = col+1;
        
        if(!isInvalid(grid, prevRow, col)) {
            paths += visitAllPaths(grid, prevRow, col, endRow, endCol);
        }
        if(!isInvalid(grid, nextRow, col)) {
            paths += visitAllPaths(grid, nextRow, col, endRow, endCol);
        }
        if(!isInvalid(grid, row, prevCol)) {
            paths += visitAllPaths(grid, row, prevCol, endRow, endCol);
        }
        if(!isInvalid(grid, row, nextCol)) {
            paths += visitAllPaths(grid, row, nextCol, endRow, endCol);
        }
        
        grid[row][col] = val;
        if(val == 0) {
            nonObstacleCells++;
        }
        return paths;
    }
    
    private boolean checkIfAllNonObstaclesVisited(int[][] grid) {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isInvalid(int[][] grid, int row, int col) {
        return (row < 0 || row >= rows || col < 0 || col >= cols || 
               grid[row][col] == 3 || grid[row][col] == -1
               );
    }
}