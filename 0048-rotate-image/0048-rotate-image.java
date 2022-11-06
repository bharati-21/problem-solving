class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
                
        int n = matrix.length;
        
        int left = 0, right = n-1;
        
        while(left < right) {
            for(int i = 0; i < right-left; i++) {
                int top = left, bottom = right;
                int topLeft = matrix[top][left + i];
                
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
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