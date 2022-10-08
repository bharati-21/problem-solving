class Solution {
    public int findMiddleIndex(int[] nums) {
	    if(nums == null || nums.length == 0) {
		    return -1;
        }

        int n = nums.length;
        int sum = getSum(nums);
        int[] prefixSum = getPrefixSum(nums);

        for(int i = 0; i<n; i++) {
	        int leftSum = prefixSum[i];
	        int rightSum = sum - nums[i] - prefixSum[i];
	        if(leftSum == rightSum) {
		        return i;
            }
        }

	    return -1;
    }

    private int getSum(int[] nums) {
	    int sum = 0;
	    for(int num: nums) {
		    sum += num;
        }
	    return sum;
    }

    private int[] getPrefixSum(int[] nums) {
	    int n = nums.length;
	    int[] prefixSum = new int[n];
	    for(int i = 0; i<n; i++) {
		    prefixSum[i] = (i == 0) ? 0 : (prefixSum[i-1] + nums[i-1]);
	    }
	    return prefixSum;
    }
}