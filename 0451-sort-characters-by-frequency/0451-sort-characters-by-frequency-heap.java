class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        
        int n = s.length();
        Map<Character, Integer> frequency = new HashMap();
        
        // O(n)
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(
            (a,b) -> b.getKey() - a.getKey()
        );
        
        // insetion: log(n) 
        // n element: n * log(n)
        for(char ch: frequency.keySet()) {
            Pair pair = new Pair(frequency.get(ch), ch);
            pq.add(pair);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair<Integer, Character> pair = pq.poll();
            int count = pair.getKey();
            char ch = pair.getValue();
            while(count-- != 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}


/*
tree
{t: 1}
{r: 1}
{e: 2}
eert

cccaaa
{c: 3}
{a: 3}

Aabb
{A: 1}
{a: 1}
{b: 2}
bbaA
*/
