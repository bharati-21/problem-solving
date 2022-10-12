class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
       
        int[] ways = new int[n];
        
        ways[0] = 1;
        for(int i = 0; i<n; i++) {
            int maxJump = nums[i];
            if(ways[i] == 0) {
                continue;
            }
            for(int jump = 1; jump<=maxJump; jump++) {
                int nextJump = jump+i;
                if(nextJump >= n) {
                    break;
                }
                if(nextJump == n-1) {
                    return true;
                }
                ways[nextJump]++;
            }
        }
        return ways[n-1] != 0;
    }
    
    private boolean canJumpHelper(int index, int n, int[] nums) {
        if(index >= n-1) {
            return true;
        }
        
        int jump = 1;
        int maxJump = nums[index];
        if(maxJump == 0) {
            return false;
        }
        while(jump <= maxJump && jump < n) {
            int nextJump = index + jump;
            if(canJumpHelper(nextJump, n, nums)) {
                return true;
            }
            jump++;
        }
        
        return false;
    }
}
