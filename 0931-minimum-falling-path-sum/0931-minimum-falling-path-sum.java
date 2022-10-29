class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for(int[] row: memo) {
            Arrays.fill(row, -200);
        }
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++) {
            min = Math.min(minFallingPathSumHelper(0, i, n, matrix, memo), min);
        }
        
        return min;
    }
    
    private int minFallingPathSumHelper(int i, int j, int n, int[][] matrix, int[][] memo) {
        if(i == n-1) {
            return matrix[i][j];
        }
        
        if(memo[i][j] != -200) return memo[i][j];
        
        int curr = matrix[i][j];
        int leftDiag = Integer.MAX_VALUE;
        int rightDiag = Integer.MAX_VALUE;
        
        
        int below = minFallingPathSumHelper(i+1, j, n, matrix, memo);
        if(j >= 1) {
            leftDiag = minFallingPathSumHelper(i+1, j-1, n, matrix, memo);
        }
        if(j < n-1) {
            rightDiag = minFallingPathSumHelper(i+1, j+1, n, matrix, memo);
        }
        
        int diagMin = Math.min(leftDiag, rightDiag);
        
        return memo[i][j] = curr + Math.min(diagMin, below);
    }
}