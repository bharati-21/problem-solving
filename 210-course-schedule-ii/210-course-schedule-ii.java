class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        List<List<Integer>> adj = buildAdjacencyList(numCourses, prerequisites, indegree);
        return getTopologicalOrder(adj, indegree, numCourses);
    }

    private List<List<Integer>> buildAdjacencyList(int n, int[][] prerequisites, int[] indegree) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(i, new ArrayList());
        }   

        for(int[] prerequisite: prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];
            adj.get(first).add(second);
            indegree[second]++;
        }

        return adj;
    }   

    private int[] getTopologicalOrder(List<List<Integer>> adj, int[] indegree, int n) {
        int[] order = new int[n];
        int index = 0;

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i<n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int front = queue.poll();
            order[index++] = front;
            for(int node: adj.get(front)) {
                indegree[node]--;
                if(indegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return index == n ? order : new int[0];
    } 
}