class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int i = 0;
        
        int hare = nums[0];
        int tortoise = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        while(tortoise != hare);
        
        tortoise = nums[0];
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return hare;
    }
}

/*
Naive: run 2 loops to check for repeated number
Sort: check for adjacent repeated number
Set: try adding all nums to set. The number that returns false while adding is the duplicate num
Count: place number num at num-1th index. The number that appears twice is the answer
*/