class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int prod = 1;
        
        for(int num: nums) {
            if(num == 0) {
                zeroCount++;
                continue;
            }
            
            prod *= num;
        }
        
        int[] ans = new int[nums.length];
        if(zeroCount == nums.length) {
            return ans;
        }
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                ans[i] = (zeroCount == 1) ? prod : 0;
            }
            else {
                if(zeroCount > 0) {
                    continue;
                } 
                else {
                    ans[i] = prod / nums[i];
                }
            }
        }
        
        return ans;
    }
}
