class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        
        int start = 0, end = n-1;
        
        
        while(start <= end) {
            int mid = (end + start) / 2;
            int midNum = nums[mid];
            
            int first = nums[start];
            int last = nums[end];
                        
            if(midNum == target) {
                return mid;
            }
            if(nums[start] <= midNum) {
                if(target > midNum || target < nums[start]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            // midNum >= last
            else {
                if(target < midNum || target > nums[end]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}

// 4 5 7 0 1 2 3