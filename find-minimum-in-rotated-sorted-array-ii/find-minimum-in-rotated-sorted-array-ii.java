class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else if(nums[mid] < nums[start]){
                end = mid;
            }
            else {
                end--;
            }
        }
        
        return nums[start];
    }
}