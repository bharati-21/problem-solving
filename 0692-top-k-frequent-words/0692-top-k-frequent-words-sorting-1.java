class Pair {
    String s;
    int f;
    Pair(String s, int f) {
        this.s = s;
        this.f = f;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> frequentWords = new ArrayList();
        
        HashMap<String, Integer> count = new HashMap();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        
        for(String word: words) {
            if(!count.containsKey(word)) {
                count.put(word, 0);
            }    
            count.put(word, count.get(word)+1);
        }
        
        for(String s: count.keySet()) {
            int f = count.get(s);
            Pair p = new Pair(s,f);
            if(pq.size() < k) {
                pq.offer(p);
            }
            else {
                Pair peek = pq.peek();
                if(peek.f != f && f > peek.f) {
                    pq.poll();
                    pq.offer(p);
                }
                else if(peek.f == f && peek.s.compareTo(s) > 0) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }
        
        int i = 0;
        while(i < k) {
            frequentWords.add(0,pq.poll().s);
            i++;
        }
        
        return frequentWords;
    }
}

class CustomComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if(a.f != b.f) {
            return a.f - b.f;
        }
        return b.s.compareTo(a.s);
    }
}
