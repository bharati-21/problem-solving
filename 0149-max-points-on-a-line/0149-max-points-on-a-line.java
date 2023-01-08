class Solution {
    public int maxPoints(int[][] points) {
        int count = 0;
        int n = points.length;
        if(n == 1) return 1;
        
        // 1st point
        for(int i = 0; i<n; i++) {
            int[] first = points[i];
            double x1 = first[0], y1 = first[1];
            // 2nd point
            for(int j = 0; j<n; j++) {
                if(j == i) continue;
                int[] second = points[j];
                double x2 = second[0], y2 = second[1];
                
                double gradient = (y2-y1)/(x2-x1);
                
                // other points with first and second
                int currCount = 2;
                for(int k = 0; k<n; k++) {
                    if(k == i || k == j) continue;
                    
                    int[] third = points[k];
                    double x3 = third[0], y3 = third[1];
                    
                    double currGradient = (y3-y2)/(x3-x2);
                    if(currGradient == gradient) {
                        currCount++;
                    }
                }
                
                count = Math.max(count, currCount);
            }
        }
        
        return count;
    }
}