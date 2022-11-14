class Solution {
    public int minDays(int[][] grid) {
        int islands = getNumberOfIslands(grid);
        // already disconnected
        if(islands != 1) return 0;
        
        int m = grid.length, n = grid[0].length;
        int time = 1;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 0) continue;
                int[][] gridCopy = new int[m][n];
                for(int k = 0; k<m; k++) {
                    gridCopy[k] = grid[k].clone();
                }
                gridCopy[i][j] = 0;
                islands = getNumberOfIslands(gridCopy);
                if(islands != 1) {
                    return 1;
                }
                
            }
        }
        
        return 2;
    }
    
    private int getNumberOfIslands(int[][] grid) {
        int islands = 0;
        
        
        Set<List<Integer>> visited = new HashSet();
        
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                List<Integer> list = new ArrayList();
                list.add(i);
                list.add(j);
                
                if(!visited.contains(list) && grid[i][j] == 1) {
                    dfs(i, j, visited, grid);
                    islands++;
                }
                
            }
        }
        
        return islands;
    }
    
    private void dfs(int row, int col, Set<List<Integer>> visited, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        List<Integer> list = new ArrayList();
        list.add(row);
        list.add(col);
        visited.add(list);
        
        int[][] directions = new int[][] {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };
        
        for(int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            List<Integer> subList = new ArrayList();
            subList.add(nextRow);
            subList.add(nextCol);
            if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || 
               grid[nextRow][nextCol] == 0 || visited.contains(subList)) {
                continue;
            }
            
            dfs(nextRow, nextCol, visited, grid);
        }
        
    }
}

/*
to check if the grid is connected, check if number of islands == 1
*/