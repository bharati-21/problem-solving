//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int n, m;
    private int[][] directions = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    int numberOfEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++) {
            if(!visited[i][0] && grid[i][0] == 1) {
                visiteNeighborNodes(i, 0, grid, visited);
            }
            if(!visited[i][n-1] && grid[i][n-1] == 1) {
                visiteNeighborNodes(i, n-1, grid, visited);
            }
        }
        
        for(int j = 0; j<n; j++) {
            if(!visited[0][j] && grid[0][j] == 1) {
                visiteNeighborNodes(0, j, grid, visited);
            }
            if(!visited[m-1][j] && grid[m-1][j] == 1) {
                visiteNeighborNodes(m-1, j, grid, visited);
            }
        }
        
        int enclaves = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }
    
    private void visiteNeighborNodes(int row, int col, int[][] grid, boolean[][] visited) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        
        visited[row][col] = true;
        
        for(int[] dir: directions) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            visiteNeighborNodes(nextRow, nextCol, grid, visited);
        }
    }
    
    private int countEnclaves(int row, int col, int[][] grid, boolean[][] visited, int enclaves) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        
        visited[row][col] = true;
        for(int[] dir: directions) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            enclaves += countEnclaves(nextRow, nextCol, grid, visited, enclaves);
        }
        
        return enclaves + 1;
    }
}