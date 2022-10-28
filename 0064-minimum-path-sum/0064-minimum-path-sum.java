class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        
        for(int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        return minPathSumHelper(grid, m-1, n-1, memo);
    }
    
    private int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if(row == 0 && col == 0) {
            return grid[0][0];
        }
        
        if(memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        if(col > 0) {
            left = minPathSumHelper(grid, row, col-1, memo);
        }
        if(row > 0) {
            top = minPathSumHelper(grid, row-1, col, memo);
        }
            
        return memo[row][col] = grid[row][col] + Math.min(top, left);
    }
}