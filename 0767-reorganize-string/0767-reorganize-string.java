class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character, Integer> frequency = new HashMap();
        
        for(char ch: s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        
        
        PriorityQueue<CharInfo> mh = new PriorityQueue<CharInfo>((a,b) -> b.count - a.count);
        for(char ch: frequency.keySet()) {
            int c = frequency.get(ch);
            CharInfo info = new CharInfo(ch, c);
            mh.add(info);
        }
        
        CharInfo prev = null;
        while(!mh.isEmpty()) {
            CharInfo front = mh.poll();
            char ch = front.ch;
            int c = front.count;
            
            sb.append(ch);
            c--;
            if(prev != null && prev.count > 0) {
                mh.add(prev);
            }
            
            prev = front;
            prev.count -= 1;
        }
        
        return (sb.length() == s.length()) ? sb.toString() : "";
    }
}

class CharInfo {
    char ch;
    int count;
    CharInfo(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}