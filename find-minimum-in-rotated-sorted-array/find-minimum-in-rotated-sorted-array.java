class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int start = 0, end = n-1;
        
        while(start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] < nums[start]) {
                end = mid;
            }
            else {
                if(nums[start] < nums[end]) {
                    end = mid;
                }
                else {
                    start = mid+1;
                }
            }
        }
        
        
        return nums[start];
    }
}