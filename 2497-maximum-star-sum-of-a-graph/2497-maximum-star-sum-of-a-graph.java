class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> list = new ArrayList();
      
        int n = vals.length;
        int m = edges.length;
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++) {
            list.add(i, new ArrayList());
        }
        
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            list.get(u).add(vals[v]);
            list.get(v).add(vals[u]);
        }
        
        for(int i = 0; i<n; i++) {
            List<Integer> neighbors = list.get(i);
            Collections.sort(neighbors, Collections.reverseOrder());
        }
        
        for(int i = 0; i<n; i++) {
            List<Integer> neighbors = list.get(i);
            int numNeighbors = neighbors.size();
            int sum = vals[i];
            int j = 0;
            while(j < k && j < numNeighbors) {
                int val = neighbors.get(j);
                if(val < 0) break;
                sum += val;
                j++;
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
}

/*
0 -- 1 -- 2
*/