class Solution {
    public int strStr(String haystack, String needle) {
        int[] table = lps(needle);
        int m = haystack.length(), n = needle.length();
        int i = 0, j = 0;
        
        while(i < m) {
            char first = haystack.charAt(i);
            char second = needle.charAt(j);
            if(first == second) {
                i++;
                j++;
            }
            else {
                if(j == 0) {
                    i++;
                }
                else {
                    j = table[j-1];
                }
            }
            
            if(j == n) {
                return i - needle.length();
            }
        }
        return -1;
    }
    
    private int[] lps(String s) {
        int i = 0, j = 1;
        int n = s.length();
        
        int[] table = new int[n];
        while(j < n) {
            char first = s.charAt(i);
            char second = s.charAt(j);
            if(first == second) {
                table[j] = i+1;
                i++;
                j++;
            }
            else if(i == 0) {
                table[j] = 0;
                j++;
            }
            else {
                i = table[i-1];
            }
        }
        
        return table;
    }
}