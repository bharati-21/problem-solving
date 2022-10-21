class Solution {
    public int[] twoSum(int[] nums, int target) {
	    int[] ans = new int[2];

        if(nums == null || nums.length == 0) {
            return ans;
        }

        int n = nums.length;

        for(int left = 0, right = n-1; left < right;) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                ans[0] = left+1;
                ans[1] = right+1;
                break;
            }
            else if(sum > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return ans;
    }
}

/*

*/