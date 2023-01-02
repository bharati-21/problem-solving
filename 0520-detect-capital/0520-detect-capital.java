class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) return true;
        
        int n = word.length();
        
        char last = word.charAt(n-1);
        // is the last character caps?
        boolean lastCharCaps = (last >= 65 && last <= 90);
        
        for(int j = n-2; j >= 0; j--) {
            char curr = word.charAt(j);
            
            // if the last char is caps and current char is not in caps
            if(lastCharCaps && (curr < 65 || curr > 90)) {
                return false;
            }
            // if the last char is not in caps and the current char is in caps
            // 
            else if(!lastCharCaps && j > 0 && (curr >= 65 && curr <= 90)) {
                return false;
            }
        }
        
        return true;
    }
}