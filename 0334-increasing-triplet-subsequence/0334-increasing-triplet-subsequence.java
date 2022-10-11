class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i = 0; i<n; i++) {
            int curr = nums[i];
            if(curr <= first) {
                first = curr;
            }
            else if(curr <= second) {
                second = curr;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}