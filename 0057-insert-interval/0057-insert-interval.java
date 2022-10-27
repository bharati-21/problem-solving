class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0) {
            return new int[][] {
                { newInterval[0], newInterval[1]}  
            };
        };
        List<int[]> newIntervals = new ArrayList();
        
        int n = intervals.length;
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        
        int newX = newInterval[0];
        int newY = newInterval[1];
        
        for(int[] interval: intervals) {
            int x = interval[0], y = interval[1];
            
            if(newY < x) {
                newIntervals.add(new int[] {
                    newX, newY
                });
                newX = x;
                newY = y;
            } 
            if(y < newX) {
                newIntervals.add(new int[]{
                    x, y
                });
            }
            else {
                newX = Math.min(newX, x);
                newY = Math.max(newY, y);
            }
        }
        
        newIntervals.add(new int[] {
            newX, newY
        });
        
        int[][] ans = new int[newIntervals.size()][2];
        for(int i = 0; i<newIntervals.size(); i++) {
            ans[i] = newIntervals.get(i);
        }
        
        return ans;
    }
}

