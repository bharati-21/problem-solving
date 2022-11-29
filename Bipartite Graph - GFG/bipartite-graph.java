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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private int[] visited;
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        visited = new int[V];
        
        for(int i = 0; i<V; i++) {
            if(visited[i] == 0) {
                boolean isComponentBipartite = traverseNodesAndNeighbors(i, adj);
                if(!isComponentBipartite) return false;
            }
        }
        return true;
    }
    
    private boolean traverseNodesAndNeighbors(int startNode, ArrayList<ArrayList<Integer>>adj) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(startNode);
        // 0 means unvisited
        // 1 means color 1
        // 2 means color 2
        visited[startNode] = 1;
        
        while(!nodes.isEmpty()) {
            int currNode = nodes.poll();
            int currColor = visited[currNode];
            
            for(int nextNode: adj.get(currNode)) {
                int nextColor = (currColor == 1) ? 2 : 1;
                if(visited[nextNode] == 0) {
                    visited[nextNode] = nextColor;
                    nodes.add(nextNode);
                }
                else if(visited[nextNode] == currColor) {
                    return false;
                }
            }
        }
        
        return true;
    }
}