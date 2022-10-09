class Solution {
	public boolean isSubsequence(String s, String t) {
		if(s == null && t == null || s.isEmpty() && t.isEmpty()){	
			return true;
        }
        if(t == null || t.isEmpty()) {
	        return false;
        }
        if(s == null || s.isEmpty()) {
	        return true;
        }

        int sLen = s.length(), tLen = t.length();
        if(tLen < sLen) {
	        return false;
        }
        int i = 0, j = 0;
        while(i < sLen && j < tLen) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(j);
            if(sChar == tChar) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }
}

/*

1. If there are extra characters in s, then you return false
2. If the characters present in t are not in the relative order, return false
3. If the the len(t) < len(s), return false
4. if t and s are equal return true
*/