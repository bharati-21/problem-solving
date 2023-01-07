class Solution {
    private int[] memo;
    private int n;
    public int numDecodings(String s) {
        n = s.length();
        // memo[i] represents the number of ways to decode a string starting from s[i..n-1]
        memo = new int[n];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(s, 0);
    }
    
    private int numDecodingsHelper(String s, int index) {
        if(index >= n) {
            // found 1 way to decode it
            return 1;
        }
        
        if(memo[index] != -1) return memo[index];
        
        int curr = s.charAt(index);
        
        // there's nothing starting with '0'
        if(curr == '0') return memo[index] = 0;
        
        int ways = numDecodingsHelper(s, index+1);
        
        if(index < n-1) {
            char next = s.charAt(index+1);
            if(curr == '1' || curr == '2' && next < '7') {
                ways += numDecodingsHelper(s, index+2);
            }
        }
        
        return memo[index] = ways;
    }
}