class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder num = new StringBuilder(Integer.toString(x));
        int len = num.length();
        
        for(int i = 0, j = len-1; i<j; i++, j--) {
            if(num.charAt(i) != num.charAt(j)) return false;
        }
        return true;
    }
}
