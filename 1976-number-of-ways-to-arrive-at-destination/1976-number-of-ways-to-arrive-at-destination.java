class Solution {
    private int mod = (int) (1e9 + 7);
    public int countPaths(int n, int[][] roads) {
        int[] distance = new int[n];
        int[] ways = new int[n];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        Arrays.fill(ways, 0);
        // 1 way to reach 0
        ways[0] = 1;
        
        List<List<int[]>> adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
        }
        
        for(int[] road: roads) {
            int u = road[0], v = road[1], time = road[2];
            
            adj.get(u).add(new int[] {
                v, time
            });
            adj.get(v).add(new int[] {
                u, time
            });
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], currDist = curr[1];
            
            
            for(int[] next: adj.get(currNode)) {
                int nextNode = next[0], nextDist = next[1];
                
                if((nextDist + currDist) < distance[nextNode]) {
                    pq.add(new int[] {
                        nextNode, (nextDist + currDist)
                    });
                    distance[nextNode] = (nextDist + currDist);
                    ways[nextNode] = ways[currNode];
                }
                
                else if((nextDist + currDist) == distance[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % mod;
                }
            }
        }
        
        return ways[n-1] % mod;
    }
}