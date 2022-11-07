class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        int n = strs.length;
        
        StringBuilder prefix = new StringBuilder(strs[0]);
        
        for(int i = 1; i<n; i++) {
            String s = strs[i];
            
            int j = 0;
            while(j < prefix.length() && j < s.length()) {
                if(prefix.charAt(j) != s.charAt(j)) {
                    break;
                }
                j++;
            }
            prefix.delete(j, prefix.length());
            if(prefix.isEmpty()) break;
        }
        
        return prefix.toString();
    }
}