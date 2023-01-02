class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap();
        
        String[] sArr = s.split("\s");
                
        int n = pattern.length();
        int m = sArr.length;
        
        if(n != m) return false;
        
        for(int i = 0; i<n; i++) {
            char ch = pattern.charAt(i);
            String str = sArr[i];
            
            if(!map.containsKey(ch) && !map.containsValue(str)) {
                map.put(ch, str);
            }
            else if(map.containsKey(ch) && !map.containsValue(str) ||
                   !map.containsKey(ch) && map.containsValue(str)) {
                return false;
            }
            else if(!map.get(ch).equals(str)) {
                return false;
            }
        }
        
        return true;
    }
}