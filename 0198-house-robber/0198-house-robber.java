class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int second = nums[0];
        int first = 0;
        
        for(int i = 1; i<n; i++) {
            if(i == 1) {
                first = Math.max(nums[i], second);
                continue;
            }
            
            int curr = Math.max(nums[i] + second, first);
            second = first;
            first = curr;
        }
        
        return Math.max(first, second);
    }
}