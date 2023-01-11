class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList();
        boolean applesFound = false;
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
            adj.add(new ArrayList());
            if(hasApple.get(i)) applesFound = true;
        }
        
        if(!applesFound) return 0;
        
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return walkTree(0, -1, adj, hasApple);
    }
    
    private int walkTree(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {        
        int totalTime = 0;
                
        for(int child: adj.get(node)) {
            if(parent == child) continue;
            
            int childTime = walkTree(child, node, adj, hasApple);
            // System.out.println(child + " -> " + childTime);
            totalTime += childTime;
        }
        
        
        if(parent != -1) {
            if(totalTime > 0 || (hasApple.get(node) && totalTime == 0)) {
                totalTime+=2;
            }
        }
        return totalTime;
    }
}