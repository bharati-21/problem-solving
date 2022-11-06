class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int sum = (n * (n+1))/2;
        int arrSum = 0;
        
        for(int num: nums) {
            arrSum += num;
        }
        
        return sum - arrSum;
    }
}

/*
0^3^1^0^2^1^3
*/

/*
Naive: Run outer loop from 0 to n, check for every value num, if it exists in array or not
Sort: Sort the array and if the difference between 2 nums > 1 then return the current number + 1
Set: Add all numbers to it. Iterate again from 0 to n, if a number is not in set, return that num
Count sort: place number i at ith index. At the end if every number is in it's own position return n. Else return the number that is not in it's correct position
Return Sum of n natural numbers - return the sum of elements in array 
XOR
*/