class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int minDiff = nums[k-1] - nums[0];
        
        int left = 1;
        while(left <= n-k) {
            int currDiff = nums[left+k-1] - nums[left];
            left++;
            minDiff = Math.min(currDiff, minDiff); 
        }
        return minDiff;
    }
}
