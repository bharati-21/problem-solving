class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null || prerequisites.length == 0) {
		    // If you don't have any prerequisites, then you can easily finish all the courses
		    return true;
	    }

	    int[] indegree = new int[numCourses];	
        ArrayList<ArrayList<Integer>> adj = new ArrayList(numCourses);
        for(int i = 0; i<numCourses; i++) {
            adj.add(i, new ArrayList());
        }

	    for(int[] prerequisite: prerequisites) {
		    int a = prerequisite[0];
		    int b = prerequisite[1];
		    indegree[a]++;
		    
		    adj.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++) {
	        if(indegree[i] == 0){
		        queue.add(i);
            }
        }	
	    int count = 0;
	
	    while(!queue.isEmpty()) {
		    int front = queue.poll();
		    count++;
		
		    for(int node: adj.get(front)) {
			    indegree[node]--;
			    if(indegree[node] == 0) {
				    queue.add(node);
                }
		    }
        }

        return count == numCourses;
    }
}

/*

1 -> 0

0 -> 1
1 -> 0

*/