class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> frequency = new HashMap();
        
        int n = s.length();
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch,0)+1);
        }
        
        int length = 0;
        boolean oddOccurrencesCount = false;
        for(char ch: frequency.keySet()) {
            int count = frequency.get(ch);
            if(count % 2 == 0) {
                length += count;
            }
            else {
                length += count-1;
                oddOccurrencesCount = true;
            }
        }
        return length + (oddOccurrencesCount ? 1 : 0);
    }
}
