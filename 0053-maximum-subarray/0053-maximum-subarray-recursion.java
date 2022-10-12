class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return maxSubArrayHelper(0, nums, n, false);
    }
    
    private int maxSubArrayHelper(int i, int[] nums, int n, boolean pickCurrentElement) {
        if(i >= n) {
            return pickCurrentElement ? 0 : Integer.MIN_VALUE;
        }
        
        // This is to denote that 
        // we either start the subarray from here
        // or end the sub array at the previous index
        if(pickCurrentElement) {
            int startHere = nums[i] + maxSubArrayHelper(i+1, nums, n, true);
            return Math.max(startHere, 0);
        }
        
        // We either include the number and end sub array
        int includeNum = nums[i] + maxSubArrayHelper(i+1, nums, n, true);
        // We don't include. the number and continue the subarray
        int excludeNum = maxSubArrayHelper(i+1, nums, n, false);
        return Math.max(includeNum, excludeNum);
    }
}
