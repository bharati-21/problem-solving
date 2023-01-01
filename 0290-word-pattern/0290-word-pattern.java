class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternToString = new HashMap();
        Map<String, Character> stringToPattern = new HashMap();
        
        String[] sArr = s.split("\s");
                
        int n = pattern.length();
        int m = sArr.length;
        
        if(n != m) return false;
        
        for(int i = 0; i<n; i++) {
            char ch = pattern.charAt(i);
            String str = sArr[i];
            
            if(!patternToString.containsKey(ch) && !stringToPattern.containsKey(str)) {
                patternToString.put(ch, str);
                stringToPattern.put(str, ch);
            }
            else if(patternToString.containsKey(ch) && !stringToPattern.containsKey(str) ||
                   !patternToString.containsKey(ch) && stringToPattern.containsKey(str)) {
                return false;
            }
            else if(!patternToString.get(ch).equals(str) || stringToPattern.get(str) != ch) {
                return false;
            }
        }
        
        return true;
    }
}