class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        
        int numSlices = 0;
        int[] dp = new int[n];
        
        for(int i = 2; i<n; i++) {
            int first = nums[i-1] - nums[i-2];
            int second = nums[i] - nums[i-1];
            
            if(first == second) {
                dp[i] = dp[i-1] + 1;
            }
            else {
                dp[i] = 0;
            }
        }
        
        for(int count: dp) {
            numSlices += count;
        }
        
        return numSlices;
    }
}

/*
*/
