class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        
        if(n == 2) return stones[1] - stones[0];
        
        int max = 0;
        
        int prev = stones[0];
        for(int i = 2; i<n; i+=2) {
            max = Math.max(max, stones[i] - prev);
            prev = stones[i];
        }
        
        prev = stones[1];
        for(int i = 3; i<n; i+=2) {
            max = Math.max(max, stones[i] - prev);
            prev = stones[i];
        }
        
        return max;
    }
}

/*
0 2 4
4 3 1 0
*/