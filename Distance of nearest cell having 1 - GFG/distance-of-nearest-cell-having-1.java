//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    private int m, n;
    private int[][] directions;
    
    public int[][] nearest(int[][] grid)
    {
        m = grid.length;
        n = grid[0].length;
        int[][] distance = new int[m][n];
        directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        Queue<Triplet> cells = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) {
                    Triplet cell = new Triplet(row, col, 0);
                    cells.add(cell);
                    visited[row][col] = true;
                }
            }
        }
        
        getMinimumDistance(cells, grid, visited, distance);
        return distance;
    }
    
    private void getMinimumDistance(Queue<Triplet> cells, int[][] grid, boolean[][] visited, int[][] distance) {
        while(!cells.isEmpty()) {
            Triplet currCell = cells.poll();
                
            int currRow = currCell.row, currCol = currCell.col, currLevel = currCell.level;
                
            for(int[] direction: directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                int nextLevel = currLevel + 1;
                
                Triplet nextCell = new Triplet(nextRow, nextCol, nextLevel);
                if(isInvalidCell(nextRow, nextCol, visited)) {
                    continue;
                }
                    
                if(grid[nextRow][nextCol] == 0) {
                    distance[nextRow][nextCol] = nextLevel;
                }
                visited[nextRow][nextCol] = true;
                cells.add(nextCell);
            }
        }
    }
    
    private boolean isInvalidCell(int row, int col, boolean[][] visited) {
        return (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]);
    }
}

class Triplet {
    int row, col, level;
    Triplet(int row, int col, int level) {
        this.row = row;
        this.col = col;
        this.level = level;
    }
}