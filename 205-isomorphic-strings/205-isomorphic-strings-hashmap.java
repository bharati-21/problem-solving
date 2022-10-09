class Solution {
    public boolean isIsomorphic(String s, String t) {
	    if(s == null && t == null || s.isEmpty() && t.isEmpty()) {
		    return true;
        }
        if(s == null || s == null || s.isEmpty() || t.isEmpty()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        int n = s.length();

        for(int i = 0; i<n; i++) {
        char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // a sChar was already mapped to someone else
            if(map.containsKey(sChar)) {
                if(map.get(sChar) != tChar) {
                    return false;
                }
                continue;
            }
            
            // If the tChar was already mapped before but not using 
            if(map.containsValue(tChar)) {
                if(!map.containsKey(sChar)) {
                    // This means the tChar was already mapped
                    return false;
                }
                if(map.containsKey(sChar)) {
                    if(map.get(sChar) != tChar) {
                        return false;
                    }
                }
            }
            
            map.put(sChar, tChar);
        }
        
        return true;
    }
}

/*
p -> t
a -> i
p -> t
e -> l
r -> e

"badc"
"baba"

b -> b
a -> a
d -> b

*/
