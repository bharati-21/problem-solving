class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> contourPoints = new ArrayList();
        
        List<int[]> points = new ArrayList();
        generatePoints(buildings, points);
        Collections.sort(points, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int[] point: points) {
            System.out.print(Arrays.toString(point) + " ");
        }
        PriorityQueue<Integer> heights = new PriorityQueue<Integer>((a,b) -> b-a);
        heights.add(0);
        
        int max = 0;
        // pq = [0, 10]
        // currMax = 10
        // max = 0
        // curMax != max => 
        // cPoints = [[2,10]]
        // max = 10
        
        // pq = [0, 10, 15]
        // currMax = 15
        // max = 10
        // currMax != max
        // cPoints = [2,10], [3,15]
        // max = 15
        
        // pq = [0, 10, 12, 15]
        // currMax = 15
        // max = 15
        
        // pq = [0, 10, 12]
        // remove 15
        // max = 12
        
        // pq = [0, 12]
        // remove 10
        // max = 12
        // max != currMax => F
        
        // pq = [0]
        // remove 12
        // max = 0
        // max != currMax => T
        // 12,0
        // max = 0
        
        // pq = [0, 10]
        // currMax = 10
        // max != currMax => T
        // cpoints = [2,10] [3,15], [7,12] [12,0] [15,10]
        // max = 10
        
        // pq = [0, 8, 10]
        // currMax = 10
        // max = 10
        // currMax != max
        
        // pq = [0, 8]
        // currMax = 8
        // max = 10
        // cPoints = [2,10] [3,15], [7,12] [12,0] [15,10] [20,8]
        // max = 8
        
        // pq = [0]
        // remove 8
        // currMax = 0
        // max = 8
        // currMax != max
        // cPoints = [2,10] [3,15], [7,12] [12,0] [15,10] [20,8], [24,0]
        
        
        
        for(int[] point: points) {
            if(point[1] < 0) {
                heights.add(-point[1]);
            }
            else {
                // the end point is processed
                // hence remove it's height
                heights.remove(point[1]);
            }
            
            int currMax = heights.peek();
            if(currMax != max) {
                List<Integer> contour = new ArrayList();
                contour.add(point[0]);
                contour.add(currMax);
                contourPoints.add(contour);
                max = currMax;
            }
        }
        return contourPoints;
    }
    
    private void generatePoints(int[][] buildings, List<int[]> points) {
        for(int[] building: buildings) {
            int[] start = new int[] { building[0], -building[2] };
            int[] end = new int[] { building[1], building[2] };
            
            points.add(start);
            points.add(end);
        }
    }
}