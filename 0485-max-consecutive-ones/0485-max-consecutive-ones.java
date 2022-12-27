class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int start = 0, end = 0;
        
        while(end < n) {
            if(nums[end] == 0) {
                int len = end - start;
                maxLen = Math.max(maxLen, len);
                start = end+1;
            }
            end++;
        }
        
        maxLen = Math.max(maxLen, (end - start));
        return maxLen;
    }
}

/*
Naive approach is to use two loops. i and j, whenever nums[i] == 1, check from i+1 to n and note the maximum length

nums = [1,1,0,1,1,1]
start = 0, end = 0
nums[0] == 0 => F

start = 0, end = 1
nums[1] == 0 => F

start = 0, end = 2
nums[2] == 0 => T
len - (2-0) = 2
maxLen = max(0, len) => 2
start = 3

start = 3, end = 3
nums[3] == 0 => F

start = 3, end = 4
*/