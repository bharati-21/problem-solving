class Solution {
    public int maxPoints(int[][] points) {
        int count = 0;
        int n = points.length;
        if(n == 1) return 1;
        
        
        // 1st point
        for(int i = 0; i<n; i++) {
            Map<List, Integer> gradientCount = new HashMap();
            int[] first = points[i];
            int x1 = first[0], y1 = first[1];
            // 2nd point
            for(int j = 0; j<n; j++) {
                if(j == i) continue;
                int[] second = points[j];
                int x2 = second[0], y2 = second[1];
                
                int dx = x2 - x1;
                int dy = y2 - y1;
                
                List<Integer> gradient = new ArrayList();
                
                if(dx == 0) {
                    gradient.add(1);
                    gradient.add(0);
                }
                if(dy == 0) {
                    gradient.add(0);
                    gradient.add(1);
                }
                else {
                    int gcd = getGCD(dy, dx);
                    gradient.add(dy/gcd);
                    gradient.add(dx/gcd);
                }
                
                gradientCount.put(gradient, 
                    gradientCount.getOrDefault(gradient,0)+1);
            }
            
            for(Map.Entry<List, Integer> entry: 
                gradientCount.entrySet()) {
                int slopeCount = entry.getValue();

                count = Math.max(slopeCount+1, count);
            }
        }
        
        
        
        return count;
    }
    
    private int getGCD(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }
        
        return getGCD(num2, num1%num2);
    }
}

/*
gcd(36,24)
gcd(24, 36%24) => gcd(24,12)
gcd(12,24%12) => gcd(12, 0)

*/