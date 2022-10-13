class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
		
		int n = s.length();
		int maxLen = 0;
        int[] seen = new int[256];
        Arrays.fill(seen, -1);
        
        int left = 0, right = 0;
		while(right < n) {
            char ch = s.charAt(right);
            
            // If this char was previously seen, then
            int lastSeen = seen[ch];            
			if(lastSeen != -1) {
                left = Math.max(left, lastSeen+1);
            }
            
			seen[ch] = right;
            maxLen = Math.max(maxLen, right-left+1);
            right++;
		}
        
        return maxLen;
	}
}
/*
--- left = 0
- space : 0
--- maxLen = 1
- a: 1
--- maxLen = 2
- c: 2
--- maxLen = 3
- i: 3
--- maxLen = 4
- f: 4
--- maxLen = 5
- u: 5
--- maxLen = 6
- i: 6
--- maxLen = 6, left = 4
- s: 7
--- maxLen = 6
- 0: 8
--- maxLen = 6 (8-4+1, 6)
- space: 9
--- maxLen = 6 (9-4+1, 6)
- 7: 10
*/


/*
a: 0
-- maxLen: 1
b: 1
-- maxLen = 2
c: 3
-- maxLen = 3
a : 4
-- maxLen = 3, left = max(0, 0+1) => 1
*/
