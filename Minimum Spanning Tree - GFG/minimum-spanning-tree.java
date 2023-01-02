//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Edge implements Comparable<Edge> {
    int u, v, wt;
    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    
    public int compareTo(Edge e) {
        return this.wt - e.wt;
    }
}

class UnionFind {
        int[] parent, rank;
        int n;
        UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            
            for(int i = 0; i<n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }
        
        int find(int u) {
            if(parent[u] == u) return u;
            
            return parent[u] = find(parent[u]);
        }
        
        void union(int u, int v) {
            int parU = find(u);
            int parV = find(v);
            
            if(parU == parV) {
                return;
            }
            
            if(rank[parU] > rank[parV]) {
                parent[parV] = parU;
            }
            else if(rank[parU] < rank[parV]) {
                parent[parU] = parV;
            }
            else {
                parent[parV] = parU;
                rank[parU]++;
            }
        }
    }

class Solution
{
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int weightSum = 0;
        
        List<Edge> edgeList = new ArrayList<Edge>();

        for(int i = 0; i<adj.size(); i++) {
            ArrayList<ArrayList<Integer>> edge = adj.get(i);
            for(ArrayList<Integer> e: edge) {
                Edge newEdge = new Edge(i, e.get(0), e.get(1));
                edgeList.add(newEdge);
            }
        }
        
        UnionFind uf = new UnionFind(V);
        Collections.sort(edgeList);
        
        for(Edge edge: edgeList) {
            int u = edge.u, v = edge.v;
            
            int parU = uf.find(u);
            int parV = uf.find(v);
            
            if(parU == parV) continue;
            
            uf.union(u, v);
            weightSum += edge.wt;
        }
        
        return weightSum;
    }
}


