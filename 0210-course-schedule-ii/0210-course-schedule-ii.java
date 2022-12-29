class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i<numCourses; i++) {
            adj.add(new ArrayList());
        }
        
        for(int[] prerequisite: prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            
            adj.get(b).add(a);
        }
        
        int[] indegree = new int[numCourses];
        for(int course = 0; course < numCourses; course++) {
            for(int nextCourse: adj.get(course)) {
                indegree[nextCourse]++;
            }
        }
        
        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList();
        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {
                queue.add(course);   
            }
        }
        
        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            order[index++] = currCourse;
            
            for(int nextCourse: adj.get(currCourse)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        
        return (index == numCourses) ? order: new int[0];
    }
}
