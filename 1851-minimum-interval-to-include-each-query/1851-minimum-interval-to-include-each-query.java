class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] queriesCopy = queries.clone();
        Arrays.sort(queriesCopy);
        int n = intervals.length;
        int m = queries.length;
        
        // add the interval size
        Map<Integer,Integer> ans = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        
        int i = 0;
        for(int query: queriesCopy) {
            while(i < n && intervals[i][0] <= query) {
                int left = intervals[i][0], right = intervals[i][1];
                int[] arr = new int[] {
                    right - left + 1,
                    right
                };
                
                pq.add(arr);
                i++;
            }
            
            // poll the invalid intervals that are to the left of interval
            while(!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }
            
            if(!pq.isEmpty()) {
                ans.put(query, pq.peek()[0]);
            }
            else {
                ans.put(query, -1);
            }
        }
        
        int[] smallest = new int[m];
        for(int q = 0; q<m; q++) {
            int query = queries[q];
            smallest[q] = ans.get(query);
        }
        
        return smallest;
    }
}