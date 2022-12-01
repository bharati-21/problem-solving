class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        // Greedy to take courses that end faster
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        int time = 0;
        int count = 0;
        
        for(int i = 0; i<n; i++) {
            int[] course = courses[i];
            int duration = course[0];
            int lastDay = course[1];
            
            if(time + duration <= lastDay) {
                time += duration;
                // adds all the courses taken in the first count places of courses array
                courses[count++] = course;
            }
            else {
                int maxDuration = i;
                for(int j = 0; j<count; j++) {
                    if(courses[maxDuration][0] < courses[j][0]) {
                        maxDuration = j;
                    }
                }
                    
                // If a previous course was taken that was of a very long duration
                // replace it with the current course
                if(duration < courses[maxDuration][0]) {
                    // subtract the extra time taken by the maxDuration course
                    // as we have replaced it with a course of lesser duration
                    int saveTime = duration - courses[maxDuration][0];
                    time += saveTime;
                    courses[maxDuration] = course;
                }
                
            }
        }
        
        return count;
    }
}