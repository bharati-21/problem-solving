class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        leftSum[0] = 0;
        for(int i = 1; i<n; i++) {
            leftSum[i] = nums[i-1] + leftSum[i-1];
        }
        
        rightSum[n-1] = 0;
        for(int i = n-2; i>=0; i--) {
            rightSum[i] = nums[i+1] + rightSum[i+1];
        }
    
        for(int i = 0; i<n; i++) {
            if(leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}

// [0, 1, 8, 11, 17, 22]
// [27, 20, 17, 11, 6, 0]
// At index = 0. sumL = 0, sumR = 27
// At index = 1. sumL = 1, sumR = 20
// At index = 2. sumL = 8, sumR = 17
// At index = 3. sumL = 11, sumR = 11
// At index = 4. sumL = 17, sumR = 6
// At index = 5. sumL = 22, sumR = 0

// [0, 1, 3]
// [5, 3, 0]
// At index = 0. sumL = 0, sumR = 5
// At index = 1. sumL = 1, sumR = 3
// At index = 2. sumL = 3, sumR = 0

// [0, 2, 3]
// [0, -1, 0]
// At index = 0. sumL = 0, sumR = 0
// At index = 1. sumL = 2, sumR = -1
// At index = 2. sumL = 3, sumR = 0

// TC: O(n) traversing through the entire array
// SC: O(n) using 2 arrays of each n size
