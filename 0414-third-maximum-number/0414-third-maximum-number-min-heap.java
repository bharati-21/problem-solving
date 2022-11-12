class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet();
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num: nums) {
            if(set.contains(num)) continue;
            if(pq.size() == 3) {
                if(pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
                    set.add(num);
                }
            }
            else {
                pq.add(num);
                set.add(num);
            }
        }
        
        if(pq.size() == 3) {
            return pq.poll();
        }
        
        int num = 0;
        while(!pq.isEmpty()) {
            num = pq.poll();
        }
        
        return num;
    }
}

/*
sort: sort numbers are return n-1-3 (if n < 3 return num[n-1]) O(n logn)
heap: maintain a heap sort of length 3 
*/

/*
1 2 4 5 6 7
2 4 5 1 6 5 1 6 7
2 4 5
*/
