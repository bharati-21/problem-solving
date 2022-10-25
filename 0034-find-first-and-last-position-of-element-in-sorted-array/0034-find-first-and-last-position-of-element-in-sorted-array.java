class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] position = new int[] {
            -1, -1
        };
        if(nums == null || nums.length == 0) {
            return position;
        }
        
        int n = nums.length;
        int start = 0, end = n-1;
        int first = Integer.MAX_VALUE, last = -1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
                        
            if(nums[mid] >= target) {
                if(target == nums[mid] && mid < first) first = mid;
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }   
        
        if(nums[start] == target) {
            first = start;
        }
        
        if(first == Integer.MAX_VALUE) {
            first = -1;
            return position;
        }
        
        start = first;
        end = n-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= target) {
                if(target == nums[mid] && mid > last) last = mid;
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }   
        if(nums[start] == target) {
            last = start;
        }
        
        return new int[] { first, last };
    }
}