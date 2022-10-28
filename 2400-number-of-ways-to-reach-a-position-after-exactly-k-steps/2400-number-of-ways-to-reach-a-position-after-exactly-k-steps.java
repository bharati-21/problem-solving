class Solution {
    int mod = (int) (7 + 1e9);
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] memo = new int[3001][k+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        int ways = numberOfWaysHelper(startPos, endPos, k, memo);
        return ways;
    }
    
    private int numberOfWaysHelper(int start, int end, int k, int[][] memo) {
        if(k < 0) {
            return 0;
        }
        
        if(k == 0) {
            if(start == end) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        if(memo[start+1000][k] != -1) {
            return memo[start+1000][k] % mod;
        }
        
        int left = numberOfWaysHelper(start-1, end, k-1, memo) % mod;
        int right = numberOfWaysHelper(start+1, end, k-1, memo) % mod;
        
        return memo[start+1000][k] = (left + right) % mod;
    }
}