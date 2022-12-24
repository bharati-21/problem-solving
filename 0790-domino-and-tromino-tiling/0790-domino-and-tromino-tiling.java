class Solution {
    int mod = (int) (1e9 + 7);
    long[] memo, tromino;
    public int numTilings(int n) {
        memo = new long[n+1];
        tromino = new long[n+1];
        
        Arrays.fill(memo, -1);
        Arrays.fill(tromino, -1);
        
        return (int) numTilingsHelper(n) % mod;
    }
    
    private long numTilingsHelper(int n) {
        if(n <= 0) return 0l;
        if(n <= 2) return n;
        
        if(memo[n] != -1) return memo[n] % mod;
        
        // f(n-1) + f(n-2) + 2*g(n-1)
        long vert = numTilingsHelper(n-1) % mod;
        long hor = numTilingsHelper(n-2) % mod;
        long tro = numTilingsTromino(n-1) % mod;
        
        return memo[n] = (vert + hor + 2 * tro) % mod;
    }
    
    private long numTilingsTromino(int n) {
        if(n <= 1) return 0l;
        if(n == 2) return 1l;
        
        if(tromino[n] != -1) return tromino[n];
        
        // g(n) = g(n-1) + f(n-1)
        long hor = numTilingsTromino(n-1) % mod;
        long tro = numTilingsHelper(n-2) % mod;
                
        return tromino[n] = (hor + tro) % mod;
    }
}