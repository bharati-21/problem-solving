class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        if(n == 1) {
            return s;
        }
        
        int[][] memo = new int[n][n];
        
        // for all the strings of length 1
        // which starts and ends at the same character 
        // the longest palindromic substring length is 1
        for(int i = 0; i<n; i++) {
            memo[i][i] = 1;
        }
        
        int longestSubstring = 0;
        String ans = "";
        
        for(int i = 0; i<n; i++) {
            String odd = expandCenter(i, i, n, s, longestSubstring);
            String even = expandCenter(i, i+1, n, s, longestSubstring);
            
            if(odd.length() >  ans.length()) {
                ans = odd;
            }
            if(even.length() > ans.length()) {
                ans = even;
            }
            
            longestSubstring = ans.length();
        }
       
        return ans;
    }
    
    private String expandCenter(int start, int end, int n, String s, int longestSubstring) {
        String ans = "";
        while(start >= 0 && end < n) {
            char sCh = s.charAt(start);
            char eCh = s.charAt(end);
            if(sCh != eCh) {
                return ans;
            }
                
            int len = end-start+1;
            if(len > longestSubstring) {
                longestSubstring = len;
                ans = s.substring(start,end+1);
            }
                
            start--;
            end++;
        }  
        
        return ans;
    } 
}