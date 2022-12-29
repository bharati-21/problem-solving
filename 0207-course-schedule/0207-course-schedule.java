class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        Queue<Integer> queue = new LinkedList();
        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {
                queue.add(course);   
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            count++;
            
            for(int nextCourse: adj.get(currCourse)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        
        return (count == numCourses);
    }
}