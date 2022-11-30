class Solution {
    public int leastInterval(char[] tasks, int n) {
        int numTasks = tasks.length;
        if(numTasks == 0) return tasks.length;
    
        // check all tasks are the same
        boolean areAllTasksSame = true;
        char firstTask = tasks[0];
        for(char task: tasks) {
            if(task != firstTask) {
                areAllTasksSame = false;
                break;
            }
        }
        
        if(areAllTasksSame) {
            int totalCooldownPeriod = numTasks - 1;
            int cooldownTime = totalCooldownPeriod * n;
            return cooldownTime + numTasks;
        }
        
        // get count of each task
        // populate task queue
        Map<Character, Integer> taskCount = new HashMap();
        PriorityQueue<Integer> remainingTasks = new PriorityQueue<Integer>((a,b) -> b-a);
        for(char task: tasks) {
            if(!taskCount.containsKey(task)) {
                taskCount.put(task, 0);
            }
            int count = taskCount.get(task);
            taskCount.put(task, count + 1);
        }
        
        for(int count: taskCount.values()) {
            remainingTasks.add(count);
        }
        
        Queue<Task> queue = new LinkedList();
        int totalTime = 0;
        
        while(!remainingTasks.isEmpty() || !queue.isEmpty()) {
            totalTime += 1;
            
            if(!remainingTasks.isEmpty()) {
                int numLeft = remainingTasks.poll() - 1;
                if(numLeft != 0) {
                    int cooldown = totalTime + n;
                    queue.add(new Task(numLeft, cooldown));
                }
            }
            if(!queue.isEmpty()) {
                int topTaskCooldown = queue.peek().cooldown;
                if(topTaskCooldown == totalTime) {
                    remainingTasks.add(queue.poll().numLeft);
                }
            }
        }
        
        return totalTime;
    }
}

class Task {
    int numLeft, cooldown; 
    Task(int n, int c) {
        numLeft = n;
        cooldown = c;
    }
}
