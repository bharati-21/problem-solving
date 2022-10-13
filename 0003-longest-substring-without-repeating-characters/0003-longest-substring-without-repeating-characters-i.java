class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
		    
		int n = s.length();
		int maxLength = 0;
		Set<Character> substring = new HashSet();
		int left = 0, right = 0;
		while(left < n && right < n) {
			char ch = s.charAt(right);
			if(!substring.contains(ch)) {
				// If the character is not seen in the substring
				// then increase the window
				// add current char to set
				substring.add(ch);
				right++;
            }
            else {
                // The character is already present in the substring
                // save the previous window
                // delete the left most character
                int windowLen = right - left;
                maxLength = Math.max(maxLength, windowLen);
                char leftChar = s.charAt(left);
                substring.remove(leftChar);
                left++;
            }

		}
		return Math.max(maxLength, (right-left));	
    }
}
