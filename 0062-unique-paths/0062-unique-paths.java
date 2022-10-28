class Solution {    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                int top = 0, left = 0;
                if(i > 1) {
                    top = dp[i-1][j];
                }
                if(j > 1) {
                    left = dp[i][j-1];
                }
                
                dp[i][j] = top + left;
            }
        }
        
        return dp[m][n];
    }
}