class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int num = nums[i];
            int index = nums[i]-1;
            if(nums[index] == num) {
                i++;
                continue;
            }
            int temp = nums[index];
            nums[index] = num;
            nums[i] = temp;
        }
        
        for(i = 0; i<n; i++) {
            if(nums[i] != i+1) return nums[i];
        }
        
        return -1;
    }
}

/*
Naive: run 2 loops to check for repeated number
Sort: check for adjacent repeated number
Set: try adding all nums to set. The number that returns false while adding is the duplicate num
Count: place number num at num-1th index. The number that appears twice is the answer
*/