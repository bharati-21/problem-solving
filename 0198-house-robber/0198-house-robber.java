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
        // return robHelper(nums, 0, n, memo);
    }
    
    private int robHelper(int[] nums, int index, int n, int[] memo) {
        if(index >= n) {
            return 0;
        }
        
        if(memo[index] != -1) {
            return memo[index];
        }
        
        int money = nums[index];
        // If I rob now, I can rob at index + 2
        // If I don't rob now, I can rob at index+1
        
        int robNow = money + robHelper(nums, index+2, n, memo);
        int robNext = robHelper(nums, index+1, n, memo);
        
        return memo[index] = Math.max(robNow, robNext);
    }
}