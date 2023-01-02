class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int max = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];
        
        for(int[] row: distance) {
            Arrays.fill(row, max);
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                    continue;
                }
            }
        }
        
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            distance[u][v] = weight;
            distance[v][u] = weight;
        }
        
        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(distance[i][k] == max || distance[k][j] == max) continue;
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        
        int city = 0, count = max;
        
        for(int i = n-1; i>=0; i--) {
            int currCount = 0;
            for(int j = 0; j<n; j++) {
                if(distance[i][j] <= distanceThreshold) {
                    currCount++;
                }
            }
            
            if(count > currCount) {
                count = currCount;
                city = i;
            }
        }
        
        return city;
    }
}