class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // nodes from 1 to n
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        
        List<List<int[]>> adjacencyList = new ArrayList();
        for(int i = 0; i<=n; i++) {
            adjacencyList.add(new ArrayList());
        }
        
        for(int[] time: times) {
            int src = time[0];
            int dest = time[1];
            int wt = time[2];
            
            adjacencyList.get(src).add(new int[] {
                dest, wt
            });
        }
        
        PriorityQueue<int[]> nodesToProcess = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        nodesToProcess.add(new int[] {
            k, 0
        });
        
        while(!nodesToProcess.isEmpty()) {
            int[] currNodeToProcess = nodesToProcess.poll();
            int currNode = currNodeToProcess[0], currTime = currNodeToProcess[1];
            
            for(int[] nextNodeToProcess: adjacencyList.get(currNode)) {
                int nextNode = nextNodeToProcess[0], 
                nextTime = currTime + nextNodeToProcess[1];
                
                if(nextTime < distance[nextNode]) {
                    distance[nextNode] = nextTime;
                    nodesToProcess.add(new int[] {
                        nextNode, nextTime
                    });
                }
            }
        }
        
        int minTime = 0;
        for(int i = 1; i<=n; i++) {
            if(i == k) continue;
            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            minTime = Math.max(distance[i], minTime);
        }
        
        return minTime;
    }
}