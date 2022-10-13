class Solution {
	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return true;
        }

		int n = s.length();
		int left = 0, right = n-1;

		while(left < right) {
			char leftCh = s.charAt(left);
			char rightCh = s.charAt(right);

			if(!isAlphaNumeric(leftCh)) {
                left++;
                continue;
            }
            if(!isAlphaNumeric(rightCh)) {
                right--;
                continue;
            }
            leftCh = convertToLowerCase(leftCh);
			rightCh = convertToLowerCase(rightCh);
            
			if(leftCh != rightCh) {
				return false;
            }
            left++;
            right--;
        }
		
        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
	
	private char convertToLowerCase(char ch) {
		if(ch >= 'A' && ch <= 'Z') {
			return (char) (ch + 32);
        }

        return ch;
    }
}
