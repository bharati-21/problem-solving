class Solution {
    private int n;
    private int[] cache;
    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        cache = new int[target+1];
        Arrays.fill(cache, -1);
        return combinationSumHelper(nums, target);
    }
    
    private int combinationSumHelper(int[] nums, int target) {
        if(target < 0) {
            return 0;
        }
        
        if(target == 0) {
            return 1;
        }
        
        if(cache[target] != -1) {
            return cache[target];
        }
        
        int ways = 0;
        
        for(int i = 0; i<n; i++) {
            ways += combinationSumHelper(nums, target-nums[i]);
        }
        
        return cache[target] = ways;
    }
}