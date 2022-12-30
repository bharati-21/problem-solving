class Solution {
    private int n;
    private List<List<Integer>> paths;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        paths = new ArrayList();
        
        traverseNodes(0, graph, new ArrayList());
        
        
        return paths;
    }
    
    private void traverseNodes(int node, int[][] graph, List<Integer> path) {
        path.add(node);
        if(node == n-1) {
            paths.add(new ArrayList(path));
        }
        
        for(int nextNode: graph[node]) {
            traverseNodes(nextNode, graph, path);
        }
        
        path.remove(path.size()-1);
    }
}

/*
- adjacency list:
0 -> [4,3,1]
1 -> [3,2,4]
2 -> [3]
3 -> [4]
4 -> []

0 -> 4
0 -> 3 -> 4
0 -> 1 -> 3 -> 4
0 -> 1 -> 2 -> 3 -> 4
0 -> 1 -> 4
*/

/*
dfs(0)
path = [0]

*/