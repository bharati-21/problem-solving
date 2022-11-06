class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[] colZeros = new boolean[n], rowZeros = new boolean[m];
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int cell = matrix[i][j];
                if(cell == 0) {
                    rowZeros[i] = true;
                    colZeros[j] = true;
                }
            }
        }
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(colZeros[j]) {
                    matrix[i][j] = 0;
                }
                if(rowZeros[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}