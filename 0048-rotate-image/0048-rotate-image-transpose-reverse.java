class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
                
        getTranspose(matrix);
        reverseCols(matrix);
    }
    
    private void getTranspose(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i<n; i++) {
            for(int j = i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reverseCols(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n; row++) {
            for(int lCol = 0, rCol = n-1; lCol < rCol; lCol++, rCol--) {
                int temp = matrix[row][lCol];
                matrix[row][lCol] = matrix[row][rCol];
                matrix[row][rCol] = temp;
            }
        }
    }
}

/*
1 4 7
2 5 8
3 6 9

7 4 1
8 5 2
9 6 3
*/
