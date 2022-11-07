class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int n = s.length();
        
        int i = n-1;
        while(s.charAt(i) == ' ') {
            i--;
        }
        
        for(; i>=0; i--) {
            if(s.charAt(i) == ' ') break;
            len++;
        }
        
        return len;
    }
}