//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        int rows = heights.length, cols = heights[0].length;
        
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        PriorityQueue<int[]> nodesToProcess = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]
        );
        nodesToProcess.add(new int[] { 0, 0, 0 });
        
        int[][] distance = new int[rows][cols];
        for(int[] dist: distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        distance[0][0] = Integer.MAX_VALUE;
        
        int maxEffort = 0;
        
        while(!nodesToProcess.isEmpty()) {
            int[] currNode = nodesToProcess.poll();
            int currRow = currNode[0], currCol = currNode[1], currDiff = currNode[2];
            
            if(currRow == rows-1 && currCol == cols-1) {
                return currDiff;
            }
            
            int currNodeHeight = heights[currRow][currCol];
            

            for(int[] dir: directions) {
                int nextRow = currRow + dir[0],
                nextCol = currCol + dir[1];
                
                if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                
                int nextNodeHeight = heights[nextRow][nextCol];
                int diff = Math.abs(nextNodeHeight - currNodeHeight);
                diff = Math.max(diff, currDiff);

                if(distance[nextRow][nextCol] > diff) {
                    distance[nextRow][nextCol] = diff;
                    nodesToProcess.add(new int[] {
                        nextRow, nextCol, diff
                    });
                }
            }
        }
        
        return 0;
    }
}