class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int startZero = minCostClimbingStairsHelper(cost, 0, n, memo);
        int startOne = minCostClimbingStairsHelper(cost, 1, n, memo);
        return Math.min(startZero, startOne);
    }
    
    private int minCostClimbingStairsHelper(int[] cost, int index, int n, int[] memo){
        if(index >= n) {
            return 0;
        }
        
        if(memo[index] != -1) {
            return memo[index];
        }
        
        int c = cost[index];
        int climbOne = c + minCostClimbingStairsHelper(cost, index+1, n, memo);
        int climbTwo = c + minCostClimbingStairsHelper(cost, index+2, n, memo);
        
        return memo[index] = Math.min(climbOne, climbTwo);
    }
}