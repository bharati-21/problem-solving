class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> mergedIntervals = new ArrayList();
        int[] interval = intervals[0];
        int n = intervals.length;
        
        for(int i = 1; i<n; i++) {
            int[] currInterval = intervals[i];
            if(isNotOverlapping(interval, currInterval)) {
                mergedIntervals.add(interval);
                interval = currInterval;
            }
            else {
                interval[0] = Math.min(currInterval[0], interval[0]);
                interval[1] = Math.max(currInterval[1], interval[1]);
            }
        }
        
        mergedIntervals.add(interval);
        int[][] answer = new int[mergedIntervals.size()][2];
        int i = 0;
        for(int[] currInterval: mergedIntervals) {
            answer[i] = currInterval;
            i++;
        }
        
        return answer;
    }
    
    private boolean isNotOverlapping(int[] interval1, int[] interval2) {
        return (interval1[1] < interval2[0]);
    }
}