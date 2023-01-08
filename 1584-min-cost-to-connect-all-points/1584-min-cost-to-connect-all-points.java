class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]>[] adj = new ArrayList[n];
        
        // 0 -> [[],[]]
        for(int i = 0; i<n; i++) {
            adj[i] = new ArrayList();
        }
        
        for(int i = 0; i<n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j<n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int d = Math.abs(x2-x1) + Math.abs(y2-y1);
                
                adj[i].add(new int[]{
                    j, d
                });
                adj[j].add(new int[]{
                    i, d
                });
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{
            0,0
        });
        
        int sum = 0;
        boolean[] visited = new boolean[n];
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currI = curr[0];
            int currD = curr[1];
            
            if(visited[currI]) continue;
            visited[currI] = true;
            sum += currD;
            
            for(int[] next: adj[currI]) {
                int nextI = next[0];
                int nextD = next[1];
                
                if(visited[nextI]) continue;
                
                pq.add(new int[] {
                    nextI, nextD
                });
            }
        }
        
        return sum;
    }
}