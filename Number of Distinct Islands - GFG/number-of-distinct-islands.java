//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private Set<List<List<Integer>>> islandImages = new HashSet<>();
    private boolean[][] visited;
    private int rows, cols;
    private int[][] directions = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    int countDistinctIslands(int[][] grid) {
        int distinctIslands = 0;
        
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    traverseNeighbors(row, col, grid);
                }
            }
        }
        
        return islandImages.size();
    }
    
    private void traverseNeighbors(int row, int col, int[][] grid) {
        Queue<int[]> cells = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>(); 
        
        int[] cell = new int[] {
            row,
            col
        };
        visited[row][col] = true;
        cells.add(cell);
        
        while(!cells.isEmpty()) {
            int[] currCell = cells.poll();
            int currRow = currCell[0], currCol = currCell[1];

            List<Integer> subList = new ArrayList<>();
            subList.add(currRow-row);
            subList.add(currCol-col);
            list.add(subList);

            for(int[] direction: directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                
                if(isInvalidCell(nextRow, nextCol, grid)) {
                    continue;
                }
                
                int[] nextCell = new int[] {
                    nextRow, nextCol
                };
                cells.add(nextCell);
                visited[nextRow][nextCol] = true;
            }
        }
        
        islandImages.add(list);
    }
    
    private boolean isInvalidCell(int row, int col, int[][] grid) {
        return (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0 || visited[row][col]);
    }
}
