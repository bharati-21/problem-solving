class Solution {
    int mod = (int) (1e9 + 7);
    int[] memo;
    public int numTilings(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        return numTilingsHelper(n);
    }
    
    private int numTilingsHelper(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        if(n == 3) return 5;
        
        if(memo[n] != -1) return memo[n] % mod;
        
        int vert = 2 * numTilingsHelper(n-1) % mod;
        int tro = numTilingsHelper(n-3) % mod;
        
        return memo[n] = (vert + tro) % mod;
    }
}