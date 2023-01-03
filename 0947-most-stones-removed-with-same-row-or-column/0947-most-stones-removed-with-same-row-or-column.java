class UnionFind {
    Map<String, String> parent;
    Map<String, Integer> rank;
    
    UnionFind(int[][] stones) {
        parent = new HashMap();
        rank = new HashMap();
        
        for(int[] stone: stones) {
            String r = stone[0] + "r";
            String c = stone[1] + "c";
            
            parent.put(r, r);
            parent.put(c, c);
            
            rank.put(r, 0);
            rank.put(c, 0);
        }
    }
    
    String find(String r) {
        if(parent.get(r).equals(r)) {
            return r;
        }
        
        String newP = find(parent.get(r));
        parent.put(r, newP);
        return newP;
    }
    
    void union(String r, String c) {
        String parR = find(r);
        String parC = find(c);
        
        if(parR.equals(parC)) {
            return;
        }
        
        if(rank.get(parR) > rank.get(parC)) {
            parent.put(parC, parR);
        }
        else if(rank.get(parR) < rank.get(parC)) {
            parent.put(parR, parC);
        }
        else {
            parent.put(parR, parC);
            rank.put(parR, rank.get(parR) + 1);
        }
    }
    
    int getNumComponents() {
        int components = 0;
        for(Map.Entry<String, String> map: parent.entrySet()) {
            if(map.getKey().equals(map.getValue())) {
                components++;
            }
        }
        
        return components;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones);
        
        for(int[] stone: stones) {
            uf.union(stone[0]+"r", stone[1]+"c");
        }
        
        return stones.length - uf.getNumComponents();
    }
}

/*

[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]

- [[0,0],[0,1],[1,0],[1,2],[2,1]] ==> [2,2] shares as col as [1,2]
- [[0,0],[0,1],[1,0],[1,2]] ==> [2,1] shares the same column as [0,1]
- [[0,0],[0,1],[1,0]] ==> [1,2] shares the as row as [1,0]
- [[0,0],[0,1]] ==> [1,0] shares the same row as [0,0]
- [[0,0]] ==> [0,1] shares the same row as [0,0]


[[0,0],[0,2],[1,1],[2,0],[2,2]]
- [[0,0],[0,2],[1,1],[2,0]] ==> [2,2] shares same row as [2,0]
- [[0,0],[0,2],[1,1]] ==> [2,0] shares same col as [0,0]
- [[0,0],[1,1]] ==> [0,1] shares same row as [0,0]
*/