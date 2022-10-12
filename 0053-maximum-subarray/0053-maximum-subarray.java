class Solution {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
		for(int i = 0; i<n; i++) {
			int continueSubset = currSum + nums[i];
			int newSubset = nums[i];
			if(continueSubset > newSubset) {
				currSum = continueSubset;
            }
            else {
                currSum = newSubset;
            }
            
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
		return maxSum;
    }
}

/*
1. Brute Force:
- Run 2 loops and keep calculating the sum of numbers in subset and keep track of a max. Compare everytime
*/