class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        
        int n = cost.length;
        
        int startZero = cost[0];
        int startOne = Math.min(cost[0]+cost[1], cost[1]);
        
        // Can either start from 0 or 1
        // start from 0, the cost is 0,
        // start from 1, the cost is min(0+1, 1)
        // to reach 2, the cost is either from 1, or 0
        // to reach 3, the cost is either from 2, or 1
        for(int i = 2; i<=n; i++) {
            int c = i == n ? 0 : cost[i];
            int curr = Math.min(c + startZero, c + startOne);
            startZero = startOne;
            startOne = curr;
        }
        
        return startOne;
    }
}
