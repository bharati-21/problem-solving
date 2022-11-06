class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        
        int n = nums.length;
        int i = 0;
        
        while(i < n) {
            int num = nums[i];
            int index = num-1;
            if(num <= 0 || num > n || nums[index] == num) {
                i++;
                continue;
            }
            
            int temp = nums[index];
            nums[index] = num;
            nums[i] = temp;
        }
        
        for(i = 0; i<n; i++) {
            if(nums[i] != i+1) return i+1;
        }
        
        return n+1;
    }
}