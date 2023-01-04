class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        TreeSet<int[]> set = new TreeSet<int[]>((a,b) -> {
            if(a[2] == b[2]) {
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        set.add(new int[] { 0, 0, grid[0][0] });
        
        int[][] distance = new int[rows][cols];
        for(int[] row: distance) {
            Arrays.fill(row, rows*cols);
        }
        distance[0][0] = grid[0][0];
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        while(!set.isEmpty()) {
            int[] curr = set.first();
            set.remove(curr);
                        
            int row = curr[0], col = curr[1], weight = curr[2];
            
            if(row == rows-1 && col == cols-1) {
                return distance[row][col];
            }
            
            for(int[] dir: directions) {
                int nRow = dir[0] + row, nCol = dir[1] + col;
                
                if(nRow < 0 || nCol < 0 || nRow >= rows || nCol >= cols) {
                    continue;
                }
                
                int nWeight = grid[nRow][nCol];
                nWeight = Math.max(weight, nWeight);
                
                if(nWeight < distance[nRow][nCol]) {
                    int[] next = new int[] {
                        nRow, nCol, distance[nRow][nCol]
                    };
                    
                    set.remove(next);
                    distance[nRow][nCol] = nWeight;
                    next[2] = nWeight;
                    set.add(next);
                }
            }
        }
        
        return -1;
    }
}