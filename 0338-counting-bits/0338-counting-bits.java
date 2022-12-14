class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[1];
        
        int offset = 1;
        int[] dp = new int[n+1];
        
        for(int i = 1; i<=n; i++) {
            if(offset * 2 == i) {
                offset *= 2;
            }
            dp[i] = 1 + dp[i-offset];
        }
        
        return dp;
    }
}