class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        
        int numSlices = 0;
        
        for(int i = 0; i<n-2; i++) {
            int first = nums[i];
            int second = nums[i+1];
            int diff = (second - first);
            for(int j = i+2; j<n; j++) {
                int third = nums[j];
                if(nums[j] - second == diff) {
                    second = nums[j];
                    numSlices++;
                }
                else {
                    break;
                }
            }
        }
        
        return numSlices;
    }
}
