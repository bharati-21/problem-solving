class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int start = 0, end = n-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            // target lies in the left half of the search space
            if(nums[mid] > target) {
                end = mid - 1;
            }
            // target lies in the right half of the search space
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            // element found
            else {
                return mid;
            }
        }

        return -1;
    }
}