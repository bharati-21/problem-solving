class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
       
        boolean[] ways = new boolean[n];
        
        ways[0] = true;
        for(int i = 0; i<n; i++) {
            int maxJump = nums[i];
            if(!ways[i]) {
                break;
            }
            for(int jump = 1; jump<=maxJump; jump++) {
                int nextJump = jump+i;
                if(nextJump >= n) {
                    break;
                }
                if(nextJump == n-1) {
                    return true;
                }
                ways[nextJump] = true;
            }
        }
        return ways[n-1];
    }
    
    // O(N^N) at max N branches and each of that N branches makes N-1 further calls
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
