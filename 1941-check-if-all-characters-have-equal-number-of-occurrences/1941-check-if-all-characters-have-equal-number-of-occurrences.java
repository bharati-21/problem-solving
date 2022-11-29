class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> occurrences = new HashMap();
        int n = s.length();
        
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            if(!occurrences.containsKey(ch)) {
                occurrences.put(ch, 0);
            }
            int count = occurrences.get(ch);
            occurrences.put(ch, count + 1);
        }
        
        int count = 0;
        for(int value: occurrences.values()) {
            if(count == 0) {
                count = value;
                continue;
            }
            
            if(count != value) return false;
        }
        
        return true;
    }
}