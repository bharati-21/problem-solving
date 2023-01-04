class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, grid[0][0] });
        
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], weight = curr[2];
            visited[row][col] = true;
            
            if(row == rows-1 && col == cols-1) {
                return weight;
            }
            
            for(int[] dir: directions) {
                int nRow = dir[0] + row, nCol = dir[1] + col;
                
                if(nRow < 0 || nCol < 0 || nRow >= rows || nCol >= cols ||
                  visited[nRow][nCol]) {
                    continue;
                }
                
                int nWeight = Math.max(grid[nRow][nCol], weight);
                
                pq.add(new int[] {nRow, nCol, nWeight });
            }
        }
        
        return -1;
    }
}