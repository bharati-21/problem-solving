class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int[] prefixSum = new int[n];
        
        prefixSum[0] = 0;
        for(int i = 1; i<n; i++) {
            prefixSum[i] = nums[i-1] + prefixSum[i-1];
        }
        
        for(int i = 0; i<n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = sum - nums[i] - prefixSum[i];
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}

// TC: O(n)
// SC: O(n)