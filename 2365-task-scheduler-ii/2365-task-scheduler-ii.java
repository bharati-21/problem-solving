class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        long days = 0;
        // represents that task i was completed on day d
        // next time the same task needs to be completed
        // we have to check if day - taskday[i] > space
        Map<Integer, Long> taskDay = new HashMap();
        int i = 0;
        while(i < n) {
            int task = tasks[i];
            if(taskDay.containsKey(task)) {
                long lastTaskDay = taskDay.get(task);
                if(days - lastTaskDay <= space)
                    days += (space - (days - lastTaskDay));
            }
            days++;
            taskDay.put(task, days);
            i++;
        }
        
        return days;
    }
}

/*
map = {}
day = 0
i = 0
- day++ (day = 1)
- task = 1
- map = {1 = 1}
i = 1
- day++ (day = 2)
- task = 2
- map = {1 = 1, 2 = 2}
i = 2
- day++ (day = 3)
- task = 1
- lastTaskDay = 1
- numSpaces = 3-1 = 2
- how many more spaces needed? 3-2 = 1
(3 - (3-1))
- 3 - 1 = 2 <= 3 --> T
- days += (2)
- days = 5
- map = {1 = 5, 2 = 2}
i = 3
- day++ = 6
- task = 2
- map = {1=5, 2=6}
i = 4
- day++ = 7
- task = 7 
- map = {1=5, 2-6, 3=7}
i = 5
- day++ = 8
- task = 1
- lastTaskDay = 5
- 8 - 5 = 3
*/

/*
1 2 b b 1 2 3 b 1
*/