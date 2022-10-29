class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;        
        int[][] dp = new int[n][n];
        
        // base case
        for(int i = 0; i<n; i++) dp[0][i] = matrix[0][i];
        
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // you can either start from 0th col, 1st col, .., n-1th col in 1st row
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int top = dp[i-1][j];
                int leftDiag = (j >= 1) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightDiag = (j < n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;
                int diagMin = Math.min(leftDiag, rightDiag);
                dp[i][j] = Math.min(dp[i][j], matrix[i][j] + Math.min(diagMin, top));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) min = Math.min(min, dp[n-1][i]);
        return min;
    }
}