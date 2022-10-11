class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            int curr = nums[i];
            if(curr < fMin) {
                fMin = curr;
            }
            else if(curr < sMin && curr > fMin) {
                sMin = curr;
            }
            else if(curr > fMin && curr > sMin) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Intuition
- traverse i from 0 to n-2
- traverse j from i+1 to n-1
- traverse k from j+1 to n
- If i<j<k && nums[i] < nums[j] < nums[k] => return true => O(n^2)
*/


/*

*/
