class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        
        for(int i = 1; i<n; i++) {
            if(i == 1) {
                dp[i] = Math.max(dp[i-1], nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        return dp[n-1];
    }
}
