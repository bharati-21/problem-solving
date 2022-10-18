class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return robHelper(nums, 0, n);
    }
    
    private int robHelper(int[] nums, int index, int n) {
        if(index >= n) {
            return 0;
        }
        
        int money = nums[index];
        // If I rob now, I can rob at index + 2
        // If I don't rob now, I can rob at index+1
        
        int robNow = money + robHelper(nums, index+2, n);
        int robNext = robHelper(nums, index+1, n);
        
        return Math.max(robNow, robNext);
    }
}
