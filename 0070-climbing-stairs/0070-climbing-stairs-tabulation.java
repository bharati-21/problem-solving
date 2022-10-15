class Solution {
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n <= 2) {
            return n;
        }    
    
        int[] tabulation = new int[n+1];
        
        tabulation[1] = 1;
        tabulation[2] = 2;

        for(int i = 3; i<=n; i++) {
            int first = tabulation[i-1];
            int second = tabulation[i-2];
            
            tabulation[i] = first + second;
        }
        
        return tabulation[n];
    }
}
