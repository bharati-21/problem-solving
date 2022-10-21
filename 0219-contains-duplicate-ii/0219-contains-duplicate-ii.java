class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        Set<Integer> set = new HashSet();
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            // If the window of [i, i+k] is done
            // remove the left most number
            // E.g. if the window was k = 2, and i was 3, [0,1,2,3], then we 
            // remove oth 
            if(i-k > 0) {
                int leftMostNum = i-k-1;
                set.remove(nums[leftMostNum]);
            }
            if(!set.add(num)) {
                return true;
            }
        }
        
        
        return false;
    }
}
