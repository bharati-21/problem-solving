class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

	    int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int perimeter = 0;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int cell = grid[i][j];
                if(!visited[i][j] && cell == 1) {
                    perimeter += getPerimeter(i, j, m, n, grid, visited);
                }
            }
        }
        return perimeter;
    }

    private int getPerimeter(int row, int col, int m, int n, int[][] grid, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList();
        
        Pair cell = new Pair(row, col);
        queue.add(cell);
        
        visited[row][col] = true;
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
	
	    int perimeter = 0;
        
	    while(!queue.isEmpty()) {
		    Pair parent = queue.poll();
		    int currRow = parent.row, currCol = parent.col;
		    for(int[] dir: directions) {
			    int nextRow = currRow + dir[0];
			    int nextCol = currCol + dir[1];
                
			    if(isValidCell(m, n, nextRow, nextCol)) {
				    if(visited[nextRow][nextCol]) {
					    continue;
				    }
                    
                    int side = getSide(nextRow, nextCol, grid);
				    perimeter += side;
				    
                    if(side == 0) {
                        visited[nextRow][nextCol] = true;
    				    queue.add(new Pair(nextRow, nextCol));
                    }
                }
                else {
                    perimeter += 1;	
                }
            }
	    }
        return perimeter;
    }

    private boolean isValidCell(int m, int n, int row, int col) {
	    if(row < 0 || row >= m || col < 0 || col >= n) {
		    return false;
        }
        return true;
    }

    private int getSide(int row, int col, int[][] grid) {
	    if(grid[row][col] == 0) {
		    return 1;
	    }
	    return 0;
    }
}

/*  
    0,1 =>
        -1,1 => Invalid so the top is a boundary so add 1 to perimeter
        1,1 => Since it's a valid cell and the cell below is a land, you don't add 1 to perimeter
        0,0 => Valid cell but not a land, so add 1
        0,2 => Valid cell but not a land, so add 2
    1,1
        => 0,1 => already visited
        => 2,0 => Valid but then the below is a land so don't add 1
        => 1,0 => Valid but then the left is a land so don't add 1
        => 1,2 => Valid but then the right is a land so don't add 1
*/