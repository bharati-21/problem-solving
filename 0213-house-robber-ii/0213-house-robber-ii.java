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
        int first = 0; int second = 0;
        for(int i = index; i<n; i++) {
            int cost = nums[i];
            int curr = Math.max(cost + first, second);
            first = second;
            second = curr;
        }
        return second;
    }
}