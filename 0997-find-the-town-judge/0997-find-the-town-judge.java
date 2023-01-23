class Solution {
    public int findJudge(int n, int[][] trust) {
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        for(int[] t: trust) {
            int a = t[0], b = t[1];
            if(!map.containsKey(b)) {
                map.put(b, new ArrayList());
            }
            map.get(b).add(a);
        }
                
        int judge = -1;
        for(int key: map.keySet()) {
            List<Integer> trustees = map.get(key);
            if(trustees.size() == n-1) {
                if(judge != -1) {
                    return -1;
                }
                judge = key;
            }
        }
        
        if(judge == -1 && n == 1) return 1;
        
        
        for(List<Integer> trustees: map.values()) {
            if(trustees.contains(judge)) {
                return -1;
            }
        }
        
        return judge;
    }
}