class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int sum = getSum(nums);
        
        int maxSum = nums[0], minSum = nums[0];
        int currMin = 0, currMax = 0;
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            currMin = Math.min(num, currMin + num);
            currMax = Math.max(num, currMax + num);
            
            maxSum = Math.max(currMax, maxSum);
            minSum = Math.min(currMin, minSum);
        }
        
        if(maxSum < 0) return maxSum;
        
        int circularSum = sum - minSum;
        
        return Math.max(circularSum, maxSum);
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        
        return sum;
    }
}