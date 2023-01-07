class Solution {
    private int n;
    int[] cache;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        cache = new int[n];
        Arrays.fill(cache, -1);
        
        int lis = cache[0];
        for(int i = 0; i<n; i++) {
            lis = Math.max(lis, LISHelper(nums, i));
        }
        
        return lis;
    }
    
    private int LISHelper(int[] nums, int index) {
        // index represents the max LIS that can be obtained 
        // when the subsequence ends at index
        
        // base case
        if(index < 0) return 0;
        
        if(cache[index] != -1) return cache[index];
        
        int num = nums[index];
        int lis = 1;
        for(int i = 0; i < index; i++) {
            if(nums[i] < num) {
                int extendWithPrev = 1 + LISHelper(nums, i);
                lis = Math.max(lis, extendWithPrev);
            }
        }
        
        return cache[index] = lis;
    }
}