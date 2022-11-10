class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int m = sb.length();
            if(m > 0 && ch == sb.charAt(m-1)) {
                sb.delete(m-1, m);
            }
            else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}