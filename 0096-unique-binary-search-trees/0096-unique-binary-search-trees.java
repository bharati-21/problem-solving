class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        return numTreesHelper(n);
    }
    
    private int numTreesHelper(int n) {
        if(n <= 1) return 1;
        
        if(dp[n] != 0) return dp[n];
        int total = 0;
        
        for(int i = 1; i<=n; i++) {
            // root all is here
            total += numTreesHelper(i-1) * numTreesHelper(n-i);
        }
        return dp[n] = total;
    }
}