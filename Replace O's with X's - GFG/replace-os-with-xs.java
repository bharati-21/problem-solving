//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static int[][] directions = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    
    static char[][] fill(int n, int m, char a[][])
    {
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for(char[] row: grid) {
            Arrays.fill(row, 'X');
        }
        
        for(int row = 0; row < n; row++) {
            if(a[row][0] == 'O') {
                traverseAdjacentNodes(row, 0, a, grid, visited);
            }
            
            if(a[row][m-1] == 'O') {
                traverseAdjacentNodes(row, m-1, a, grid, visited);
            }
        }
        
        for(int col = 0; col < m; col++) {
            if(a[0][col] == 'O') {
                traverseAdjacentNodes(0, col, a, grid, visited);
            }
            
            if(a[n-1][col] == 'O') {
                traverseAdjacentNodes(n-1, col, a, grid, visited);
            }
        }
        
        return grid;
    }
    
    private static void traverseAdjacentNodes(int row, int col, char[][] a, char[][] grid, boolean[][] visited) {
        int n = a.length, m = a[0].length; 
        
        if(row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || a[row][col] == 'X') {
            return;
        }
        
        visited[row][col] = true;
        grid[row][col] = 'O';
        
        for(int[] dir: directions) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            
            traverseAdjacentNodes(nextRow, nextCol, a, grid, visited);
        }
    }
}