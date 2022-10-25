class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int start = 0, end = n-1;
        
        while(start < end) {
            int mid = (end + start)/2;
            
            // the mid greater/ equal to the smallest element in the left
            if(nums[mid] >= nums[start]) {
                if(nums[start] < nums[end]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                end = mid;
            }
        }
        
        return nums[start];
    }
}