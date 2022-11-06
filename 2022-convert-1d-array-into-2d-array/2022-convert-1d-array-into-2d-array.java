class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original == null || original.length == 0 || m == 0 || n == 0) {
            return new int[0][0];
        }
        
        int length = original.length;
        
        if(length != m*n) {
            return new int[0][0];
        }
        
        int[][] twoD = new int[m][n];
        
        int index = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                twoD[i][j] = original[index++];
            }
        }
        
        return twoD;
    }
}