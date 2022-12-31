//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int node, dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<List<Integer>>> adj = new ArrayList<List<List<Integer>>>();
        
        for(int i = 0; i<=n; i++) {
            adj.add(new ArrayList<List<Integer>>());
        }
        
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            
            List<Integer> uList = new ArrayList<Integer>();
            uList.add(v);
            uList.add(wt);
            
            List<Integer> vList = new ArrayList<Integer>();
            vList.add(u);
            vList.add(wt);
            
            adj.get(u).add(uList);
            adj.get(v).add(vList);
        }
        
        int[] from = new int[n+1];
        int[] dist = new int[n+1];
        
        Arrays.fill(from, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        from[1] = 1;
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.dist - b.dist);
        
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()) {
            Pair currPair = pq.poll();
            int currNode = currPair.node;
            int currDist = currPair.dist;
            
            for(List<Integer> next: adj.get(currNode)) {
                int nextNode = next.get(0), nextNodeDist = next.get(1);
                
                int nextDist = currDist + nextNodeDist;
                
                if(nextDist < dist[nextNode]) {
                    from[nextNode] = currNode;
                    dist[nextNode] = nextDist;
                    
                    pq.add(new Pair(nextNode, nextDist));
                }
            }
        }
        
        List<Integer> order = new ArrayList();
        if(from[n] == -1) {
            order.add(-1);
            return order;
        }
        
        int node = n;
        while(from[node] != node) {
            order.add(0, node);
            node = from[node];
        }
        
        order.add(0, 1);
        return order;
    }
}

/*
1 - [2,2], [4,1]
2 - [1,2], [5,5], [3,4]
3 - [2,4], [4,3], [5,1]
4 - [1,1], [3,3]
5 - [2,5], [3,1]
*/