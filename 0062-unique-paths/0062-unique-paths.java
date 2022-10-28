class Solution {    
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return uniquePathsHelper(m, n, memo);
    }
    
    private int uniquePathsHelper(int m, int n, int[][] memo) {
        if(m == 1 && n == 1) {
            return 1;
        }
        
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        
        int left = 0, top = 0;
        if(m > 1) {
            top = uniquePathsHelper(m-1, n, memo);
        }
        if(n > 1) {
            left = uniquePathsHelper(m, n-1, memo);
        }
        
        return memo[m][n] = (top + left);
    }
}