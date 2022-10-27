class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int overlaps = 0;
        
        int n = img1.length;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                overlaps = Math.max(overlaps, countOverlap(img1, img2, i, j));
                overlaps = Math.max(overlaps, countOverlap(img2, img1, i, j));
            }
        }
        
        return overlaps;
    }
    
    private int countOverlap(int[][] a, int[][] b, int aRowStart, int aColStart) {
        int n = a.length;
        int sumLeft = 0, sumRight = 0;
        
        int bRow = 0, bCol = 0;
        
        for(int i = aRowStart; i<n; i++) {
            bCol = 0;
            for(int j = aColStart; j<n; j++) {
                if(a[i][j] == 1 && a[i][j] == b[bRow][bCol]) {
                    sumLeft++;
                }
                if(a[i][bCol] == 1 && b[bRow][j] == a[i][bCol]) {
                    sumRight++;
                }
                bCol++;
            }
            bRow++;
        }
        return Math.max(sumLeft, sumRight);
    }
}