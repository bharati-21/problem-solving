class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        
        // sort by start time
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        
        int[] prev = points[0];
        int numArrows = 0;
        
        for(int i = 1; i<points.length; i++) {
            int[] curr = points[i]; 
            if(doesNotOverlap(prev, curr)) {
                numArrows++;
                prev = curr;
            }
            else {
                prev[0] = Math.max(prev[0], curr[0]);
                prev[1] = Math.min(prev[1], curr[1]);
            }
        }
        
        return (numArrows+1);
    }
    
    private boolean doesNotOverlap(int[] prev, int[] curr) {
        return (prev[1] < curr[0] || prev[0] > curr[1]);
    }
}