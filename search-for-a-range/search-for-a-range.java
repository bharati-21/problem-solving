class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] position = new int[] {
            -1, -1
        };
        
        if(nums == null || nums.length == 0) {
            return position;
        }
        
        int n = nums.length;
        int first = getPosition(nums, target, true);
        if(first == -1) {
            return position;
        }
        int second = getPosition(nums, target, false);
        return new int[] {
            first, second
        };
    }
    
    private int getPosition(int[] nums, int target, boolean first) {
        int start = 0, end = nums.length - 1;
        int pos = -1;
        
        while(start < end) {
            int mid = (end + start)/2;
    
            if(target > nums[mid]) {
                start = mid + 1;
            }
            else if(target < nums[mid]) {
                end = mid;
            }
            else {
                pos = mid;
                if(first) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        
        if(nums[start] == target) {
            pos = start;
        }
        return pos;
    }
}