class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a,b) -> a[0]-b[0]);
        
        List<int[]> combinedPoints = new ArrayList();
        int[] prevPoint = points[0];
        for(int i = 1; i<n; i++) {
            int[] currPoint = points[i];
            // check if points are intersecting
            if(areNotIntersecting(currPoint, prevPoint)) {
                combinedPoints.add(prevPoint);
                prevPoint = currPoint;
            }
            else {
                prevPoint[0] = Math.max(prevPoint[0], currPoint[0]);
                prevPoint[1] = Math.min(prevPoint[1], currPoint[1]);
            }
        }
        combinedPoints.add(prevPoint);
        return combinedPoints.size();
    }
    
    private boolean areNotIntersecting(int[] p1, int[] p2) {
        return (p1[0] > p2[1] || p1[1] < p2[0]);
    }
}

/*

[1,6], [2,8], [7,12], [10,16]

given point p1 and p2
we need to find if p1 and p2 have an intersection

[[1,4],[2,3],[3,4],[4,5]]

[1,4]


[[1,2],[2,3],[3,4],[4,5]]


*/