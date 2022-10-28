class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList();
        }
        
        List<List<String>> groups = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        
        for(String str: strs) {
            String countRepresentation = getCountRepresentation(str);
            if(!map.containsKey(countRepresentation)) {
                map.put(countRepresentation, new ArrayList());
            }
            map.get(countRepresentation).add(str);
        }
        
        for(String countRepresentation: map.keySet()) {
            System.out.println(countRepresentation);
            groups.add(map.get(countRepresentation));
        }
        
        return groups;
    }
    
    private String getCountRepresentation(String s) {
        int[] count = new int[26];
        
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++) {
            int c = count[i];
            char ch = (char)('a' + i);
            while(c-- > 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}