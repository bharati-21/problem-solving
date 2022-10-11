class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        
        int n = s.length();
        int i = 0, j = n-1;
        while(i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right) {
                // check if the string is palindrome if we exlude the left char or right char
                boolean excludeLeft = isPalindrome(i, j-1, s);
                boolean excludeRight = isPalindrome(i+1, j, s) ;
                if(!excludeLeft && !excludeRight) {
                    return false;
                }
                break;
            } 
            else {
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome(int start, int end, String s) {
        while(start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(left != right) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}

/*
Intuition:
- When can a string be a palindrome? 
    - When all the characters occurs even number of times (hence even length)
    - When all characters excepth one occurs even number times (odd length)
    - When 
*/