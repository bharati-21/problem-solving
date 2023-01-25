class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distOne = new int[n];
        int[] distTwo = new int[n];
        
        Arrays.fill(distOne, Integer.MAX_VALUE);
        Arrays.fill(distTwo, Integer.MAX_VALUE);
        
        getDistance(edges, node1, new boolean[n], distOne);
        getDistance(edges, node2, new boolean[n], distTwo);
        
        int minDistNode = -1;
        int minDist = Integer.MAX_VALUE;
        
        for(int node = 0; node < n; node++) {
            int maxDist = Math.max(distOne[node], distTwo[node]);
            if(minDist > maxDist) {
                minDist = maxDist;
                minDistNode = node;
            }
        }
        
        return minDistNode;
    }
    
    private void getDistance(int[] edges, int node, boolean[]  visited, int[] dist) {
        Queue<Integer> nodes = new LinkedList();
        nodes.add(node);
        dist[node] = 0;
        
        while(!nodes.isEmpty()) {
            int currNode = nodes.poll();
            
            if(visited[currNode]) continue;
            visited[currNode] = true;
            
            int nextNode = edges[currNode];
            if(nextNode == -1 || visited[nextNode]) continue;
            
            nodes.add(nextNode);
            dist[nextNode] = dist[currNode] + 1;
        }
    }
}