class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        
        int numSlices = 0;
        int count = 0;
        int prevDiff = nums[1] - nums[0];
        
        for(int i = 2; i<n; i++) {
            int currDiff = nums[i] - nums[i-1];
            if(currDiff == prevDiff) {
                count++;
            }
            else {
                count = 0;
                prevDiff = currDiff;
            }
            numSlices += count;
        }
                
        return numSlices;
    }
}

/*
*/