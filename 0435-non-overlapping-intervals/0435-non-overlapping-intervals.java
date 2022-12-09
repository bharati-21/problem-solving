class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int n = intervals.length;
        int[] prev = intervals[0];
        int count = 0;
        
        for(int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            
            // if not overlapping
            if(prev[1] <= curr[0]) {
                prev = curr;
            } 
            else {
                count++;
                prev = (prev[1] < curr[1]) ? prev : curr;
            }
        }
        
        return count;
    }
}

/*
[1,2] [2,3] [3,4] [1,3]

[1,2], [1,3], [2,3] [3,4]

[1,2], [1,2] [1,2]


[1,2], [1,3], []
*/