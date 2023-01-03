//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class UnionFind {
    int[] parent, rank;
    int n;
    int components;
    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        components = n;
    }
    
    int find(int u) {
        if(parent[u] == u) return u;
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u), parV = find(v);
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
        components--;
    }
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        UnionFind uf = new UnionFind(V);
        
        for(int i = 0; i<V; i++) {
            for(int j = 0; j<V; j++) {
                if(adj.get(i).get(j) == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i<V; i++) {
            if(uf.find(i) == i) {
                count++;
            }
        }
        
        return uf.components;
    }
};