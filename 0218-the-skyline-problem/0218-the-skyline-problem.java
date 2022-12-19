class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> contourPoints = new ArrayList();
        
        List<int[]> points = new ArrayList();
        generatePoints(buildings, points);
        Collections.sort(points, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<Integer> heights = new PriorityQueue<Integer>((a,b) -> b-a);
        heights.add(0);
        
        int max = 0;
        
        for(int[] point: points) {
            if(point[1] < 0) {
                heights.add(-point[1]);
            }
            else {
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