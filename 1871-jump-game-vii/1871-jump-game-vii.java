class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s == null || s.length() == 0) {
            return false;
        }
        
        int n = s.length();
        if(s.charAt(n-1) == '1') {
            return false;
        }
        
        Queue<Integer> nextJumps = new LinkedList();
        nextJumps.add(0);
        Set<Integer> seen = new HashSet();
        seen.add(0);
        // This is to ensure that we don't process the same set of numbers already 
        // in the queue again and again.
        // Otherwise the inner loop with run N times.
        // since maxJump - minJump could be at most N
        int lastMaxSeen = 0;
        while(!nextJumps.isEmpty()) {
            int index = nextJumps.poll();
            char ch = s.charAt(index);
            
            if(index == n-1) {
                return ch == '0';
            }
            
            int start = Math.max(index + minJump, lastMaxSeen + 1);
            int end = index + maxJump;
            for(int next = start; next<=end && next < n; next++) {
                if(s.charAt(next) != '1' && !seen.contains(next)) {
                    seen.add(next);
                    nextJumps.add(next);
                }
            }
            lastMaxSeen = Math.max(lastMaxSeen, index + maxJump);  
        }
        
        return false;
    }
}

/*
0100000 n = 7, minJumps = 2, maxJumps = 6
i = 0
- 2, 3, 4, 5, 6 // Add 2,
i = 1
*/