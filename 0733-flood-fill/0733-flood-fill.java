class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        
        int[][] copy = new int[m][n];
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                copy[i][j] = image[i][j];
            }
        }
        
        boolean visited[][] = new boolean[m][n];
        dfs(copy, visited, sr, sc, color, image[sr][sc]);
        return copy;
    }
    
    private void dfs(int[][] copy, boolean[][] visited, int r, int c, int color, int copyColor) {
        int m = copy.length, n = copy[0].length;
        
        if(r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || copy[r][c] != copyColor) {
            return;
        }
        
        visited[r][c] = true;
        copy[r][c] = color;
        
        dfs(copy, visited, r-1, c, color, copyColor);
        dfs(copy, visited, r+1, c, color, copyColor);
        dfs(copy, visited, r, c-1, color, copyColor);
        dfs(copy, visited, r, c+1, color, copyColor);
    }
}