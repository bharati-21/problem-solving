class Solution {
    public int maxProduct(int[] nums) {
        int ans = getMax(nums);
        int max = 1, min = 1;
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                min = 1;
                max = 1;
                continue;
            }
            
            int tempMax = max;
            max = Math.max(nums[i], nums[i] * max);
            max = Math.max(max, nums[i] * min);
            
            min = Math.min(nums[i], nums[i] * min);
            min = Math.min(min, nums[i] * tempMax);
            
            ans = Math.max(ans, max);
            ans = Math.max(ans, min);
        }
        
        return ans;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for(int num: nums) {
            max = Math.max(max, num);
        }
        
        return max;
    }
}