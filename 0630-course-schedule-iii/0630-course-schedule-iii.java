class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        // Greedy to take courses that end faster
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int time = 0;
        
        for(int i = 0; i<n; i++) {
            int[] course = courses[i];
            int duration = course[0];
            int lastDay = course[1];
            
            if(time + duration <= lastDay) {
                time += duration;
                // adds all the courses taken in the first count places of courses array
                pq.add(course);
            }
            else if(!pq.isEmpty()) {
                int[] maxDurationCourse = pq.peek();
                
                if(duration < maxDurationCourse[0]) {
                    pq.poll();
                    // subtract the extra time taken by the maxDuration course
                    // as we have replaced it with a course of lesser duration
                    int saveTime = duration - maxDurationCourse[0];
                    time += saveTime;
                    pq.add(course);
                }
                
            }
        }
        
        return pq.size();
    }
}