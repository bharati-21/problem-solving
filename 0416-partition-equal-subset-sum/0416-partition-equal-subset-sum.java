class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        
        if(sum % 2 != 0) {
            return false;
        }
        
        int n = nums.length;
        int[][] memo = new int[n][sum+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        return canPartitionHelper(nums, sum/2, n-1, memo) == 0 ? false : true;
    }
    
    private int canPartitionHelper(int[] nums, int sum, int index, int[][] memo) {
        if(index == 0) {
            if(sum == nums[index]) {
                
                return 1;
            }
            return 0;
        }
        
        if(memo[index][sum] != -1) {
            return memo[index][sum];
        }
        
        int take = 0;
        if(nums[index] <= sum) {
            take = canPartitionHelper(nums, sum-nums[index], index-1, memo);
        }
        
        if(take == 1) {
            return memo[index][sum] = 1;
        }
        
        int notTake = canPartitionHelper(nums, sum, index-1, memo);
        
        return memo[index][sum] = notTake;
    }
}

/*
choose 0th index
[1] [5,11,5]
choose 1st index
[1,5] [5,11,5]
*/