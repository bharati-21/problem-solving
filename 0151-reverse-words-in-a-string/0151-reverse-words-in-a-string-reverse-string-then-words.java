class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverseString(chars, 0, n-1);
        reverseWordChars(chars);
        
        return buildString(chars);
    }
    
    private void reverseString(char[] chars, int i, int j) {
        while(i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }
    
    private void reverseWordChars(char[] chars) {
        int i = 0;
        int n = chars.length;
        while(i < n) {
            if(chars[i] == ' ') {
                i++;
                continue;
            }
            int j = i;
            while(j < n && chars[j] != ' ') {
                j++;
            }
            reverseString(chars, i, j-1);
            i = j;
        }
    }
    
    private String buildString(char[] chars) {
        int i = 0;
        int n = chars.length-1;
        StringBuilder sb = new StringBuilder();
        
        while(chars[i] == ' ') i++;
        while(chars[n] == ' ') n--;
        
        while(i <= n) {
            if(chars[i] == ' ') {
                i++; 
                continue;
            }
            int j = i;
            while(j <= n && chars[j] != ' ') {
                sb.append(chars[j]);
                j++;
            }
            if(j <= n) sb.append(chars[j]);
            i = j;
        }
        
        return sb.toString();
    }
}

/*
can use split and then reverse
eulb si yks eht
"  hello world  "
"  dlrow olleh  "
"a good   example"
"elpamaxe "
*/
