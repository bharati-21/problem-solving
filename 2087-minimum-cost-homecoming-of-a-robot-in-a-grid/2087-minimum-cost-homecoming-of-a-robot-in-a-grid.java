class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        
        int x1 = startPos[0], y1 = startPos[1];
        int x2 = homePos[0], y2 = homePos[1];
        
        int rowSum = 0;
        while(x2 != x1) {
            if(x2 < x1) {
                x1--;
            }
            else {
                x1++;
            }
            rowSum += rowCosts[x1];
        }
        
        int colSum = 0;
        while(y2 != y1) {
            if(y2 < y1) {
                y1--;
            }
            else {
                y1++;
            }
            colSum += colCosts[y1];
        }
        
        return colSum + rowSum;
    }
}

/*

2,0
-2+2
0,0
*/