class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        Arrays.sort(nums);
        int pairSum = 0;
        for(int i = 0; i<n-1; i+=2) {
            int curr = nums[i];
            int next = nums[i+1];
            int min = Math.min(curr, next);
            pairSum += min;
        }
        
        return pairSum;
    }
}

/*
[(1,3), (2,4)] = 3
[(1,2), (3,4)] = 4
[(1,4), (2,3)] = 2
[1,2,3,4]

[6,2,6,5,1,2]
[1,2,2,5,6,6]
[(1,2),(2,5),(6,6)] = 1+2+5 = 
*/