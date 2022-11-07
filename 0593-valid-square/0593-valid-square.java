class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = { p1, p2, p3, p4 };
        Arrays.sort(p, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int distance1 = dist(p[0], p[1]);
        int distance2 = dist(p[1], p[3]);
        int distance3 = dist(p[2], p[3]);
        int distance4 = dist(p[0], p[2]);
        
        int diag1 = dist(p[0], p[3]);
        int diag2 = dist(p[1], p[2]);
        
        return distance1 != 0 && 
            (distance1 == distance2) && 
            (distance2 == distance3) && 
            (distance3 == distance4) && 
            (diag1 == diag2);
    }
    
    private int dist(int[] p0, int[] p1) {
        return (p0[1] - p1[1]) * (p0[1] - p1[1]) +
            (p0[0] - p1[0]) * (p0[0] - p1[0]);
    }
}

/*
[0,0] [0,1] [1,0], [1,1]
*/