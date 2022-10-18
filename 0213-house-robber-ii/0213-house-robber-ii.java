class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        
        return Math.max(robHelper(0, n-1, nums), robHelper(1, n, nums));
    }
    
    private int robHelper(int index, int n, int[] nums) {
        int[] dp = new int[n];
        for(int i = index; i<n; i++) {
            int cost = nums[i];
            int first = (i > 1) ? dp[i-2] : 0;
            int second = (i > 0) ? dp[i-1] : 0;
            dp[i] = Math.max(cost + first, second);
        }
        return dp[n-1];
    }
}