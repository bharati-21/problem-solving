class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        boolean[] dp = new boolean[n];  
        dp[0] = true;
        for(int i = 0; i<n; i++) {
            int maxJump = nums[i];
            for(int next = i + 1; next <= i+maxJump && next < n; next++) {
                if(dp[i]) {
                    if(next == n-1) {
                        return true;
                    } 
                    dp[next] = true;
                }
            }
            
        }
        
        return dp[n-1];
    }
    
    // If you've visited an index previously, then you know the answer of reaching n-1 from that index already
    // So use the computed value
    private boolean canJumpHelper(int[] nums, int index, int n, Boolean[] memo) {
        if(index == n-1) {
            return true;
        }
        
        if(index >= n) {
            return false;
        }
        
        if(memo[index] != null) {
            return memo[index];
        }
        
        int maxJump = nums[index];
        
        for(int i = 1; i <= maxJump; i++) {
            int nextIndex = index + i;
            boolean nextJump = canJumpHelper(nums, nextIndex, n, memo);
            if(nextJump) {
                return memo[index] = true;
            }
        }
        
        // all possibilities have been seen
        return memo[index] = false;
    }
}

// Brute force can lead to n!
// Since at every index, we might have to explore n-index places