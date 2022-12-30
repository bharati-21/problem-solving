//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        int count = 0;

        for(int node = 0; node < V; node++) {
            for(int neighbor: adj.get(node)) {
                indegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int node = 0; node < V; node++) {
            if(indegree[node] == 0) {
                queue.add(node);
            }
        }
        
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            count++;
            
            for(int nextNode: adj.get(currNode)) {
                indegree[nextNode]--;
                if(indegree[nextNode] == 0) {
                    queue.add(nextNode);    
                }
            }
        }
        
        return ((count == V) ? false : true);
    }
}

/*
0 -> [3]
3 -> [2]
2 -> [1]

[0, 1, 1, 1]
*/