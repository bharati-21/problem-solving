//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int mod = (int) (1e9 + 7);
    static int countPaths(int n, List<List<Integer>> roads) {
        int[] distance = new int[n];
        int[] ways = new int[n];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        Arrays.fill(ways, 0);
        // 1 way to reach 0
        ways[0] = 1;
        
        List<List<int[]>> adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
        }
        
        for(List<Integer> road: roads) {
            int u = road.get(0), v = road.get(1), time = road.get(2);
            
            adj.get(u).add(new int[] {
                v, time
            });
            adj.get(v).add(new int[] {
                u, time
            });
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], currDist = curr[1];
            
            for(int[] next: adj.get(currNode)) {
                int nextNode = next[0], nextDist = next[1];
                
                if((nextDist + currDist) < distance[nextNode]) {
                    pq.add(new int[] {
                        nextNode, (nextDist + currDist)
                    });
                    distance[nextNode] = (nextDist + currDist);
                    ways[nextNode] = 1;
                }
                
                else if((nextDist + currDist) == distance[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % mod;
                }
            }
        }
        
        return ways[n-1] % mod;
    }
}
