class Solution {
    private int[] cache;
    public int numSquares(int n) {
        cache = new int[n+1];
        Arrays.fill(cache, -1);
        return numSquaresHelper(n);
    }
    
    private int numSquaresHelper(int n) {
        if(n == 0) {
            return 0;
        }
        
        if(cache[n] != -1) return cache[n];
        
        int numbers = Integer.MAX_VALUE;
        
        
        for(int i = 1; i*i<=n; i++) {
            int square = i*i;
            int diff = n - square;
            int ways = 1 + numSquaresHelper(diff);
            
            numbers = Math.min(ways, numbers);
        }
        
        return cache[n] = numbers;
    }
}