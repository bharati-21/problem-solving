class Solution {
    private List<List<String>> boards;
    
    public List<List<String>> solveNQueens(int n) {
        boards = new ArrayList();
        int[][] grid = new int[n][n];
        solveHelper(n, grid, 0);
        
        return boards;
    }
    
    private void solveHelper(int n, int[][] grid, int index) {
        if(index == n) {
            List<String> board = new ArrayList();
            for(int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col < n; col++) {
                    if(grid[row][col] == 1) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                
                board.add(sb.toString());
            }
            
            boards.add(board);
        }
        
        for(int col = 0; col < n; col++) {
            if(canPlace(grid, index, col, n)) {
                grid[index][col] = 1;
                solveHelper(n, grid, index+1);
                grid[index][col] = 0;
            }
        }
    }
    
    private boolean canPlace(int[][] grid, int row, int col, int n) {
        for(int i = 0; i<=row; i++) {
            if(grid[i][col] == 1) {
                return false;
            }
        }
        
        for(int i = 0; i<=col; i++) {
            if(grid[row][col] == 1) {
                return false;
            }
        }
        
        int i = row, j = col;
        while(i >=0 && j >= 0) {
            if(grid[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        
        i = row;
        j = col;
        while(i >= 0 && j < n) {
            if(grid[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}