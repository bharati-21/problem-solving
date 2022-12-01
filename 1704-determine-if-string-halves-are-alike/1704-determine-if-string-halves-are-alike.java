class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int half = n/2;
        int count = 0;
        int left = 0;
        
        while(left < half) {
            char ch = s.charAt(left);
            if(isVowel(ch)) {
                count++;
            }
            left++;
        }
        
        while(left < n) {
            char ch = s.charAt(left);
            if(isVowel(ch)) {
                if(count == 0) return false;
                count--;
            }
            left++;
        }
        
        return (count == 0);
    }
    
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' ||
                ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'
               );
    }
}