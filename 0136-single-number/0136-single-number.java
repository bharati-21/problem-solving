class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int xor = 0;
        
        for(int i = 0; i<n; i++) {
            xor ^= nums[i];
        }
        
        return xor;
    }
}

/*
Naive: compare every ith element with jth element. Any element that does not appear twice, return it
Sort: sort numbers and then compare witg adjacent values
Add all numbers to a map. Any number that has a single frequency return it
XOR: xor all numbers. The single number will be the answer/
*/