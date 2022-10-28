class Solution {    
    public int uniquePaths(int m, int n) {
        
        int[] curr = new int[n+1];
        int[] prev = new int[n+1];
        
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(i == 1 && j == 1) {
                    curr[j] = 1;
                    continue;
                }
                int top = 0, left = 0;
                if(i > 1) {
                    top = prev[j];
                }
                if(j > 1) {
                    left = curr[j-1];
                }
                
                curr[j] = top + left;
            }
            
            prev = curr;
        }
        
        return prev[n];
    }
}