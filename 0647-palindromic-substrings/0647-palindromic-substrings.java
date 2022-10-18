class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        
        int count = 0;
        for(int i = 0; i<n; i++) {
            count += helper(i, i, n, s);
            count += helper(i, i+1, n, s);
        }
        
        return count;
    }
    
    private int helper(int start, int end, int n, String s) {
        int count = 0;
        while(start >= 0 && end < n) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(left != right) {
                return count;
            }
            count++;
            end++;
            start--; 
        }
        
        return count;
    }
}

/*

abc
cba



*/