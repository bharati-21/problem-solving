class UnionFind {
    int[] root;
    int size;
    UnionFind(int size) {
        this.root = new int[size];
        
        for(int i = 0; i<size; i++) {
            root[i] = i;
        }
        this.size = size;
    }
    
    private int find(int node) {
        if(node == root[node]) {
            return node;
        }
        
        return root[node] = find(root[node]);
    }
    
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        
        if(rootU == rootV) {
            return;
        }
        
        if(rootU < rootV) {
            root[rootV] = rootU;
        }
        else {
            root[rootU] = rootV;
        }
    }
    
    public Map<Integer, PriorityQueue<Character>> buildMapping(String s) {
        Map<Integer, PriorityQueue<Character>> map = new HashMap();
        for(int i = 0; i<s.length(); i++) {
            int rootNode = find(i);
            if(!map.containsKey(rootNode)) {
                map.put(rootNode, new PriorityQueue());
            }
            map.get(rootNode).add(s.charAt(i));
            
        }
        
        return map;
    }
    
    public int getRoot(int node) {
        return find(node);
    }
}


class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        
        for(List<Integer> pair: pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            uf.union(u, v);
        }
        
        Map<Integer, PriorityQueue<Character>> map = uf.buildMapping(s);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
            int root = uf.getRoot(i);
            char ch = map.get(root).poll();
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
