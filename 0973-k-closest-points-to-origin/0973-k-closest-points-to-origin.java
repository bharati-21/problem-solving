class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            
            return (distB - distA);
        });
        
        for(int[] point: points) {
            if(pq.size() < k) {
                pq.add(point);
            }
            else {
                int[] top = pq.peek();
                int distTop = top[0]*top[0] + top[1]*top[1];
                int distCurr = point[0]*point[0] + point[1]*point[1];
                
                if(distCurr < distTop) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        
        int[][] shortest = new int[k][2];
        
        int i = 0;
        while(!pq.isEmpty()) {
            shortest[i++] = pq.poll();
        }
        
        return shortest;
    }
}