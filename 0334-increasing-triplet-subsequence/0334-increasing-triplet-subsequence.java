class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i = 1; i<n; i++) {
            int curr = nums[i];
            if(curr < first) {
                first = curr;
            }
            else if(curr < second && curr > first) {
                second = curr;
            }
            else if(curr > second) {
                return true;
            }
        }
        
        return false;
    }
}