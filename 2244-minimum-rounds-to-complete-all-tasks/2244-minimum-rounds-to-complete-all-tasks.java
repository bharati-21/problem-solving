class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> numTasksByLevel  = new HashMap();
        
        for(int task: tasks) {
            numTasksByLevel.put(task, numTasksByLevel.getOrDefault(task,0)+1);
        }
        
        int rounds = 0;
        int countOnes = 0;
        for(Map.Entry<Integer, Integer> map: numTasksByLevel.entrySet()) {
            int task = map.getKey(), numTasks = map.getValue();
            
            if(numTasks < 2) {
                return -1;
            }
            
            if(numTasks % 3 == 0) {
                rounds += numTasks/3;
            }
            
            else {
                rounds += (numTasks /3) + 1;
            }
        }
         
        return rounds;
    }
}

/*
2 - 3
3 - 2
4 - 5
*/