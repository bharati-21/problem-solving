class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        
        int n = cost.length;
        int[] dp = new int[n+1];
        
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0]+cost[1], cost[1]);
        
        // Can either start from 0 or 1
        // start from 0, the cost is 0,
        // start from 1, the cost is min(0+1, 1)
        // to reach 2, the cost is either from 1, or 0
        // to reach 3, the cost is either from 2, or 1
        for(int i = 2; i<=n; i++) {
            int first = dp[i-2];
            int second = dp[i-1];
            int c = i == n ? 0 : cost[i];
            
            dp[i] = Math.min(c + first, c + second);
        }
        
        return dp[n];
    }
}