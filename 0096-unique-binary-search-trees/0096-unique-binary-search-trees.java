class Solution {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        if(n == 2) return 2;
        
        int ans = 0;
        for(int i = 1; i<=n; i++) {
            ans += numTrees(i-1) * numTrees(n-i);
        }
        
        return ans;
    }
}