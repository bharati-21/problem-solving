class MapSum {

    Map<String, Integer> map;
    public MapSum() {
        map = new HashMap();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String key: map.keySet()) {
            if(key.length() < prefix.length()) {
                continue;
            }
            boolean hasSamePrefix = checkPrefix(key, prefix);
            if(!hasSamePrefix) {
                continue;
            }
            sum += map.get(key);
        }
        return sum;
    }
    
    private boolean checkPrefix(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        String sub = s.substring(0, m);
        if(!sub.equals(t)) {
            return false;
        }
        
        return true;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */