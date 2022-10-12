class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        int jumps = 0;
        Set<Integer> seen = new HashSet();
        Queue<Integer> nextJumps = new LinkedList();
        nextJumps.add(0);
        int lastSeenMax = 0;
        seen.add(0);
        while(!nextJumps.isEmpty()) {
            int size = nextJumps.size();
            while(size-- > 0) {
                int index = nextJumps.poll();
                if(index == n-1){
                    System.out.println(jumps);
                    return true;
                }
                int maxJump = nums[index];

                int start = Math.max(index+1, lastSeenMax+1);
                int end = index+maxJump;
                for(int next = start; next <= end && next < n; next++) {
                    if(!seen.contains(next)) {
                        nextJumps.add(next);
                    }
                }
                lastSeenMax = Math.max(end, lastSeenMax);
            }
            jumps++;
        }
        
        return false;
    }
}