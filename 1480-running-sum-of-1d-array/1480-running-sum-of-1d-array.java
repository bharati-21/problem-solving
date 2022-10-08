class Solution {
    public int[] runningSum(int[] nums) {
	    if(nums == null || nums.length == 0) {
		    return nums;
        }
        int n = nums.length;
        int[] sum = new int[n];
        for(int i = 0; i<n; i++) {
            if(i == 0) {
                sum[i] = nums[0];
            }
            else {
                sum[i] = nums[i] + sum[i-1];
            }
        }
        return sum;
    }
}

// Time Complexity: O(n), we will be traversing every element
// Space Complexity: O(1), if we don't take into account the output