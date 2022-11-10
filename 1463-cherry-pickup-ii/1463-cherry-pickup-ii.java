class Solution {
    int m, n;
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        
        int[][][] memo = new int[m][n][n];
        for(int[][] row1: memo) {
            for(int[] row2: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return cherryPickupHelper(grid, 0, 0, n-1, memo);
    }
    
    private int cherryPickupHelper(int[][] grid, int r, int c1, int c2, int[][][] memo) {
        if(r == m) {
            return 0;
        }
        
        if(memo[r][c1][c2] != -1) return memo[r][c1][c2];
        
        int total = grid[r][c1];
        
        if(c1 != c2) {
            total += grid[r][c2];
        }
    
        int[][] directions = new int[][] {
            {1, -1}, {1,0}, {1,1}
        };
        
        
        int max = 0;
        for(int[] d1: directions) {
            int nextR1 = r + d1[0];
            int nextC1 = c1 + d1[1];
            
            if(nextC1 < 0 || nextC1 >= n) continue;
            
            for(int[] d2: directions) {
                int nextR2 = r + d2[0];
                int nextC2 = c2 + d2[1];
                
                if(nextC2 < 0 || nextC2 >= n) {
                    continue;
                }
                
                int next = cherryPickupHelper(grid, nextR1, nextC1, nextC2, memo);
                max = Math.max(next, max);
            }
        }
        
        return memo[r][c1][c2] = max + total;
    }
}