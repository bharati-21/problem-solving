class Solution {
    private List<Integer> safeNodes;
    private int[] visited; 
    private int n;
    
    // 0 -> not visited
    // 1 -> visited
    // 2 -> path visited
    // 3 -> safe
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        visited = new int[n];
        safeNodes = new ArrayList();
        
        for(int node = 0; node < n; node++) {
            if(visited[node] == 0) {
                traverseNodes(graph, node);
            }
        }
        
        for(int node = 0; node < n; node++) {
            if(visited[node] == 3) {
                safeNodes.add(node);
            }
        }
        
        return safeNodes;
    }
    
    private boolean traverseNodes(int[][] graph, int node) {
        visited[node] = 2;
        
        for(int nextNode: graph[node]) {
            if(visited[nextNode] == 0) {
                boolean hasCycle = traverseNodes(graph, nextNode);
                if(hasCycle) return true;
            }
            else if(visited[nextNode] == 2) {
                return true;
            }
        }
        
        visited[node] = 3;
        return false;
    }
}

/*
- terminal node: node with no outgoing edges
- safe node: every path starting from node leads to a terminal node or another safe node
*/

/*
0 -> [1,2]
1 -> [2,3]
2 -> [5]
3 -> [0]
4 -> [5]
5 -> []
6 -> []

indegree = [1, 1, 2, 1, 0, 2, 0]
*/

/*
0 -> [1,2,3,4]
1 -> [1,2]
2 -> [3,4]
3 -> [0,4]
4 -> []

indegree = [1, 2, 2, 2, 3]
*/