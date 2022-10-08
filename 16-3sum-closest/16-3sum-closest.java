class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) {
            return Integer.MIN_VALUE;
        }
        
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        // -4 -1 1 2
        // outer = 0
            // -1, 2
            // -4-1+2 => -3 (-3 < 2 => T) (-3-1 => 4)
            // 1 2
            // -4+1+2 => -1 (-1 < 2 => T) (-1-1 => 2)
        // -1
            // 
        for(int outer = 0; outer < n-2; outer++) {
            int left = outer+1;
            int right = n-1;
            int outerNum = nums[outer];
            
            while(left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int currSum = outerNum + leftNum + rightNum;
                
                if(currSum == target) {
                    return target;
                } 
                if(Math.abs(target - currSum) < Math.abs(target-closestSum)) {
                    closestSum = currSum;
                }
                    
                if(currSum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return closestSum;
    }
}