class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        boolean firstRowZero = false;
        
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int cell = matrix[i][j];
                if(cell == 0) {
                    if(i > 0) matrix[i][0] = 0;
                    else firstRowZero = true;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int i = 0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if(firstRowZero) {
            for(int j = 0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}