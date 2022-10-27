class Pair {
    int num, frequency;
    Pair(int num, int frequency) {
        this.num = num;
        this.frequency = frequency;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i<nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num)+1);
            }
        }
        
        for(int num: map.keySet()) {
            int frequency = map.get(num);
            Pair p = new Pair(num, frequency);
            
            if(pq.size() < k) {
                pq.add(p);
            }
            else {
                Pair front = pq.peek();
                if(front.frequency < frequency) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }
        
        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            ans[index++] = pq.poll().num;
        }
        
        return ans;
    }
}

class CustomComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.frequency - p2.frequency;
    }
}