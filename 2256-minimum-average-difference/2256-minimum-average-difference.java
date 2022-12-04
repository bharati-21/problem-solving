class Solution {
    public int minimumAverageDifference(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        long prefixSum = 0;
        long total = 0;
        long minAverageDiff = Integer.MAX_VALUE;
        int minAvgIndex = -1;
        
        for(int num: nums) {
            total += num;
        }
        
        for(int i = 0; i<n; i++) {
            prefixSum += (long) nums[i];
            long right = (total - prefixSum);
            
            long leftAvg = prefixSum / (i+1); 
            long rightAvg = 0;
            if(i+1 != n) {
                rightAvg = right / (n-i-1);
            }
            
            long diff = Math.abs(leftAvg - rightAvg);
            
            if(diff < minAverageDiff) {
                minAvgIndex = i;
                minAverageDiff = diff;
            }
        }
        
        return minAvgIndex;
    }
}

/*
[2,7,10,19,24,27]
[0,3,8,17,20,25]
[2,5,3,9,5,3]
average difference at 0 => 
    |avg(i+1) - avg(n-i-1)| => |avg(1) - avg(n-1)|
    |2/1 - (5+3+9+5+3)/5|
    |2 - 5| => 3
    avg = [3]
average difference at 1 =>
    |avg(2) - avg(6-1-1)| 
    |7/2 - 20/4|
    |3 - 5| = 2
average difference at 2 =>
    |avg(3) - avg(6-2-1)|
    |10/3 - 17/3| 
    |3 - 5| => 2
average difference at 3 =>
    |avg(4) - avg(6-3-1)|
    |19/4 - 8/2|
    |4-4| => 0
average difference at 4 =>
    |avg(5) - avg(1)|
    |24/5 - 3/1|
    |4-3| => 1
averrage difference at 5 =>
    |avg(6) - avg(0)|
    |27/6 - 0|
    |4-0|
*/