class Solution {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] missing = new int[2];
        
        Arrays.sort(nums);
        
        missing[1] = 1;
        for(int i = 1; i<n; i++) {
            int num = nums[i];
            int prev = nums[i-1];
            if(prev == num) {
                missing[0] = num;
            }
            else if(num > prev+1) {
                missing[1] = prev+1;
            }
        }
        
        if(nums[n-1] != n) {
            missing[1] = n;
        }
        return missing;
    }
}

// 2 3 3 4 5 6
// 1 2 2 4
