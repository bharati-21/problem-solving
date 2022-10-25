class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n-1;
        
        while(start <= end) {
            int mid = (end+start) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            // [4,5,6,7,8,1,2] target = 8
            // [4,5,6,0,1,2,3] target = 6
            // [4,5,6,0,1,2,3] target = 3
            // [0,1,2,3,4,5,6] target = 6
            
            // [3,4,6,7,8,1,2] target = 4
            // [5,6,0,1,2,3,4] target = 0
            // [5,6,0,1,2,3,4] target = 4
            // [0,1,2,3,4,5,6] target = 2
            
            if(nums[mid] >= nums[start]) {
                if(target < nums[mid]) {
                    if(target < nums[start]) {
                        start = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    if(target < nums[start]) {
                        start = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
            }
        }
        
        return -1;
    }
}