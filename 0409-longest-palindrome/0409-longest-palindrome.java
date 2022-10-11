class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> frequency = new HashMap();
        
        boolean isAllSingleFrequency = true;
        int n = s.length();
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch,0)+1);
            if(frequency.get(ch) != 1) {
                isAllSingleFrequency = false;
            }
        }
        
        int len = 0;
        for(char ch: frequency.keySet()) {
            int freq = frequency.get(ch);
            len += (freq / 2)*2;
            if(freq % 2 == 1 && len % 2 == 0) {
                len+=1;
            }
        }
        
        return len;
    }
}
