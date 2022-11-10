class Solution {
    int m, n;
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        
        int[][][] dp = new int[m][n][n];
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                dp[m-1][i][j] = (i == j) ? grid[m-1][i] : grid[m-1][i] + grid[m-1][j];
            }
        }
        
        for(int i = m-2; i>=0; i--) {
            for(int j = 0; j<n; j++) {
                for(int k = 0; k<n; k++) {
                    int total = grid[i][j];
                    if(k != j) {
                        total += grid[i][k];
                    }
                    
                    int max = dp[i][j][k];
                    for(int col1 = -1; col1 <= 1; col1++) {
                        int c1 = j + col1;
                        if(c1 < 0 || c1 >= n) continue;

                        for(int col2 = -1; col2 <= 1; col2++) {
                            int c2 = k + col2;

                            if(c2 < 0 || c2 >= n) {
                                continue;
                            }

                            max = Math.max(max, dp[i+1][c1][c2]);
                        }
                    }
                    dp[i][j][k] = (total + max);
                }
            }
        }
        
        return dp[0][0][n-1];
    }

}