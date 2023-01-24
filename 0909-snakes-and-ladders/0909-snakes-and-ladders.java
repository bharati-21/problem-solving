class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        
        Queue<int[]> cells = new LinkedList<int[]>();
        cells.add(new int[] {
            1, 0
        });
        
        while(!cells.isEmpty()) {
            int[] curr = cells.poll();
            int currCell = curr[0], 
                currDist = curr[1];
            
            if(currCell == n*n) {
                return currDist;
            }
            
            int start = currCell+1;
            
            for(int roll = 1; roll <= 6; roll++) {
                int next = currCell + roll;
                if(next > n*n) {
                    continue;
                }
                
                int[] coordinate = getCoordinates(next, n);
                int nextRow = coordinate[0], nextCol = coordinate[1];
                
                if(visited[nextRow][nextCol]) continue;
                
                if(board[nextRow][nextCol] == -1) {
                    cells.add(new int[] {
                        next, currDist+1
                    });
                }
                else {
                    cells.add(new int[] {
                        board[nextRow][nextCol], currDist+1
                    });
                    
                }
                
                visited[nextRow][nextCol] = true;
            }
            
        }
        
        return -1;
    }
    
    private int[] getCoordinates(int next, int n) {
        int r = (next - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? next - 1 - r * n : n + r * n - next;
        return new int[] {
            x, y
        };
    }
}

/*
1 to 6 -> 0 to n-1 -- 6/6 -> 1
7 to 12 -> n-1 to 0 -- 6/6 -> 2
13 to 18 -> 0 to n-1 -- 
19 to 24 -> n-1 to 0
25 to 30 -> 0 to n-1
31 to 36 -> n-1 to 0
*/