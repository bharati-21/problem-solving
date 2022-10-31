class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        
        for(int[] row: memo) Arrays.fill(row, -1);
        return lcsHelper(text1, text2, m-1, n-1, memo);
    }
    private int lcsHelper(String s, String t, int i, int j, int[][] memo) {
        if(i == 0 && j == 0) {
            char sCh = s.charAt(0);
            char tCh = t.charAt(0);
            if(sCh == tCh) return 1;
            
            return 0;
        }
        
        if(i < 0 || j < 0) return 0;
        
        if(memo[i][j] != -1) return memo[i][j];
        
        char sCh = s.charAt(i);
        char tCh = t.charAt(j);
        
        if(sCh == tCh) {
            return 1 + lcsHelper(s, t, i-1, j-1, memo);
        }
        
        return memo[i][j] = Math.max(lcsHelper(s, t, i-1, j, memo), lcsHelper(s, t, i, j-1, memo));
    }
}