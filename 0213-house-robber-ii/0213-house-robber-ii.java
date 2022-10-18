class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int startZero = robHelper(0, n-1, nums, memo);
        
        Arrays.fill(memo, -1);
        return Math.max(startZero, robHelper(1, n, nums, memo));
    }
    
    private int robHelper(int index, int n, int[] nums, int[] memo) {
        if(index >= n) {
            return 0;
        }
        
        if(memo[index] != -1) {
            return memo[index];
        }
        
        int money = nums[index];
        int robNow = money + robHelper(index+2, n, nums, memo);
        int robNext = robHelper(index+1, n, nums, memo);
        
        return memo[index] = Math.max(robNow, robNext);
    }
}