class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rainFlow = new ArrayList();
        
        if(heights == null || heights.length == 0) {
            return rainFlow;
        }
        
        int m = heights.length, n = heights[0].length;
        Set<List<Integer>> seenOne = new HashSet(), seenTwo = new HashSet();
        
        for(int i = 0; i<n; i++) {
            dfs(0, i, m, n, seenOne, heights, heights[0][i]);
            dfs(m-1, i, m, n, seenTwo, heights, heights[m-1][i]);
        }
        
        for(int i = 0; i<m; i++) {
            dfs(i, 0, m, n, seenOne, heights, heights[i][0]);
            dfs(i, n-1, m, n, seenTwo, heights, heights[i][n-1]);
        }
        
        for(List<Integer> cellOne: seenOne) {
            if(seenTwo.contains(cellOne)) {
                rainFlow.add(cellOne);
            }
        }
        
        return rainFlow;
    }
    
    private void dfs(int row, int col, int m, int n, Set<List<Integer>> seen, int[][] heights, int value) {
        if(row < 0 || row >= m || col < 0 || col >= n || heights[row][col] < value) {
            return;
        } 
        
        List<Integer> list = new ArrayList();
        list.add(row);
        list.add(col);
       
        if(seen.contains(list)) {
            return;
        }
        
        seen.add(list);
        int currValue = heights[row][col];
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        for(int[] dir: directions) {
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            
            dfs(nr, nc, m, n, seen, heights, currValue);
        }
    }
}