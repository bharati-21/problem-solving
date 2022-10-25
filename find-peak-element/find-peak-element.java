class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        
        int peak = -1;
        int start = 0, end = n-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]) {
                if(peak == -1 || nums[mid] > nums[peak]) {
                    peak = mid;
                }
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        if(peak == -1 || nums[start] > nums[peak]) {
            peak = start;
        }
        
        return peak;
    }
}