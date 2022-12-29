class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        int[][] tasksByEnqueue = new int[n][3];
        for(int i = 0; i<n; i++) {
            int[] task = tasks[i];
            
            tasksByEnqueue[i] = new int[] {
                task[0], task[1], i
            };
        }
        Arrays.sort(tasksByEnqueue, (a,b) -> a[0] - b[0]);
        
        // [[2,4,1],[3,2,2],[4,1,3],[7,2,0]]
        // currTime = 0
        // -- no task with enqueue time <= currTime
        // currTime = 1
        // -- no task with enqueue time <= currTime
        // currTime = 2
        // [2,4,1] with enqueue time <= currTime
        // 
        
        // sort tasks by enqueue time
        PriorityQueue<int[]> processedTasks = new PriorityQueue<int[]>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int index = 0, currTime = tasksByEnqueue[index][0];
        int[] order = new int[n];
        int orderIndex = 0;
        
        while(orderIndex < n) {
            while(index < n && tasksByEnqueue[index][0] <= currTime) {
                processedTasks.add(tasksByEnqueue[index]);
                index++;
            }

            if(!processedTasks.isEmpty()) {
                int[] currTask = processedTasks.poll();
                int processTime = currTask[1];
                int taskIndex = currTask[2];
                order[orderIndex++] = taskIndex;
                currTime += processTime;
                continue;
            }
            else {
                currTime = tasksByEnqueue[index][0];
            }
        }
        
        return order;
    }
}


/*
- Need to sort with the task that has the smallest enqueue time
- It goes on until the processing ends, then the next task 
*/
/*
[[7,10],[7,12],[7,5],[7,4],[7,2]]

[4,3,2,0,1]

<processingTime, enqueuTime, Index>
- can use a PQ that sorts by the smallest to largest 
*/

/*
[[7,2],[2,4],[3,2],[4,1]]
Time = 1 -> nothing available
Time = 2 -> {1} available
{1}
Time = 3 -> Task 1 still processing {2} available
Time = 4 -> Task 1 still processing {3,2} available
Time = 5 
*/