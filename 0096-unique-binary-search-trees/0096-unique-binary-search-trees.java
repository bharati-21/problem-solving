class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        
        return numTreesHelper(n);
    }
    
    private int numTreesHelper(int n) {
        if(n <= 1) return 1;
        if(n == 2) return 2;
        
        if(dp[n] != -1) return dp[n];
            
        int ans = 0;
        for(int i = 1; i<=n; i++) {
            ans += numTreesHelper(i-1) * numTreesHelper(n-i);
        }
        
        return dp[n] = ans;
    }
}