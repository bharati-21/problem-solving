class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }
    
    private boolean isMatchHelper(String s, String p, int i, int j) {
        int m = s.length(), n = p.length();
        if(i >= m && j >= n) {
            return true;
        }
        
        if(j >= n) {
            return false;
        }
        
        boolean matches = false;
        if(i < m) {
            char sCh = s.charAt(i);
            char pCh = p.charAt(j);
            if(sCh == pCh || pCh == '.') {
                matches = true;
            }
        }
            
        int next = j+1;
        if(next < n && p.charAt(next) == '*') {
            boolean notTakeStar = isMatchHelper(s, p, i, j+2);
            return notTakeStar || (matches && isMatchHelper(s, p, i+1, j));
        }
            
        if(matches) {
            return isMatchHelper(s, p, i+1, j+1);
        }
        
        return matches;
    }
}