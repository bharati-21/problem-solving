class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int islands = 0;
        int m = grid.length, n = grid[0].length;    
        Set<List<Integer>> visited = new HashSet();
            
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                List<Integer> coordinate = new ArrayList();
                coordinate.add(row);
                coordinate.add(col);
                
                if(grid[row][col] == '1' && !visited.contains(coordinate)) { 
                    visited.add(coordinate);
                    bfs(row, col, grid, visited);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void bfs(int row, int col, char[][] grid, Set<List<Integer>> visited) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        Pair startNode = new Pair(row, col);
        queue.add(startNode);
        int[][] directions = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> parent = queue.poll();
            int parentRow = parent.getKey();
            int parentCol = parent.getValue();
                        
            for(int[] dir: directions) {
                int childRow = dir[0] + parentRow;
                int childCol = dir[1] + parentCol;
                
                List<Integer> coordinate = new ArrayList();
                coordinate.add(childRow);
                coordinate.add(childCol);
                
                if(isInvalid(childRow, childCol, grid, visited, coordinate)) {
                    continue;
                }
                
                Pair<Integer, Integer> child = new Pair(childRow, childCol);
                visited.add(coordinate);
                queue.add(child);
            }
        }
    }
    
    private boolean isInvalid(int row, int col, char[][] grid, Set<List<Integer>> visited, List<Integer> coordinate) {
        int m = grid.length, n = grid[0].length;
        return (row < 0 || row >= m || col < 0 || col >= n || 
                grid[row][col] == '0' || visited.contains(coordinate));
    }
}